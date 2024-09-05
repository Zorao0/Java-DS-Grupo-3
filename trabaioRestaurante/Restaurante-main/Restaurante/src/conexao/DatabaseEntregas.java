package conexao;

import tabelas.entrega;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseEntregas {
    
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

    public void create(entrega entregas) {
        
        String query = "INSERT INTO Entregas (Endereco,ID_pedido,Data_entrega) VALUES (?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setString(1, entregas.getEndereco());
            stmt.setInt(2, entregas.getID_pedido());
            
            Date utilDate = entregas.getData_entrega();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(3, sqlDate);
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<entrega> readAll() {
        List<entrega> entregas = new ArrayList<>();
        String query = "SELECT * FROM Entregas";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                entregas.add(new entrega(rs.getString("Endereco"),rs.getInt("ID_pedido"),rs.getDate("Data_entrega")));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return entregas;
    }

   
    public void update(entrega entregas, int id) {
       
        String query = "UPDATE Pratos SET Endereco = ?,ID_pedido = ?, Data_entrega = ? WHERE ID_entrega = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, entregas.getEndereco());
            stmt.setInt(2, entregas.getID_pedido());
            
            Date utilDate = entregas.getData_entrega();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(3, sqlDate);
                    
            stmt.setInt(4,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Entregas WHERE ID_entrega = ?";
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