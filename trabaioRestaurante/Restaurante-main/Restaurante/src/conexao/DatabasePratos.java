package conexao;

import tabelas.pratos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePratos {
    
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

    public void create(pratos prato) {
        
        String query = "INSERT INTO Pratos (Nome,Descricao,Valor) VALUES (?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setString(1, prato.getNome());
            stmt.setString(2, prato.getDescricao());
            stmt.setDouble(3, prato.getValor());
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<pratos> readAll() {
        List<pratos> prato = new ArrayList<>();
        String query = "SELECT * FROM Pratos";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                prato.add(new pratos(rs.getString("Nome"),rs.getString("Descricao"),rs.getDouble("Valor")));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return prato;
    }

   
    public void update(pratos prato, int id) {
       
        String query = "UPDATE Pratos SET Nome = ?,Descricao = ?, Valor = ? WHERE ID_prato = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, prato.getNome());
            stmt.setString(2, prato.getDescricao());
            stmt.setDouble(3, prato.getValor());
                    
            stmt.setInt(4,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Pratos WHERE ID_prato = ?";
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