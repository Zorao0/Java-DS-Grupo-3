package conexao;

import tabelas.bebidas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBebidas {
    
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

    public void create(bebidas bebida) {
        
        String query = "INSERT INTO Bebidas (Nome,Descricao,Valor) VALUES (?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setString(1, bebida.getNome());
            stmt.setString(2, bebida.getDescricao());
            stmt.setDouble(3, bebida.getValor());
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<bebidas> readAll() {
        List<bebidas> bebida = new ArrayList<>();
        String query = "SELECT * FROM Bebidas";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                bebida.add(new bebidas(rs.getString("Nome"),rs.getString("Descricao"),rs.getDouble("Valor")));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return bebida;
    }

   
    public void update(bebidas bebida, int id) {
       
        String query = "UPDATE Pratos SET Nome = ?,Descricao = ?, Valor = ? WHERE ID_prato = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, bebida.getNome());
            stmt.setString(2, bebida.getDescricao());
            stmt.setDouble(3, bebida.getValor());
                    
            stmt.setInt(4,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Bebidas WHERE ID_prato = ?";
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