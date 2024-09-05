package conexao;

import tabelas.reservas;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReserva {
    
    private static final String URL = "jdbc:mysql://localhost:3306/Restaurante";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
           
            throw new RuntimeException(e);
        }
    }

    public void create(reservas reserva) {
        
        String query = "INSERT INTO Reservas (Data_reserva,ID_cliente,Mesa,ID_filial,Capacidade) VALUES (?,?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            Date utilDate = reserva.getData_reserva();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(1, sqlDate);
            
            stmt.setInt(2, reserva.getID_cliente());
            stmt.setString(3, reserva.getMesa());
            stmt.setInt(4, reserva.getID_filial());
            stmt.setString(5, reserva.getCapacidade());
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<reservas> readAll() {
        List<reservas> func = new ArrayList<>();
        String query = "SELECT * FROM Reservas";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                func.add(new reservas(
                rs.getDate("Data_reserva"),
                rs.getInt("ID_cliente"),
                rs.getString("Mesa"),
                rs.getInt("ID_filial"),
                rs.getString("Capacidade")
                ));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return func;
    }

   
    public void update(reservas reservas, int id) {
       
        String query = "UPDATE Reservas SET Data_reserva = ?, ID_cliente = ?, Mesa = ?, ID_filial = ?, Capacidade = ? WHERE ID_reserva = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            Date utilDate = reservas.getData_reserva();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(1, sqlDate);
            
            stmt.setInt(2, reservas.getID_cliente());
            stmt.setString(3, reservas.getMesa());
            stmt.setInt(4, reservas.getID_filial());
            stmt.setString(5, reservas.getCapacidade());
                    
            stmt.setInt(6,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Reservas WHERE ID_reserva = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void testeConexao() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}