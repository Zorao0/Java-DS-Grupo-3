package conexao;

import tabelas.ingredientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseIngredientes {
    
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

    public void create(ingredientes ingrediente) {
        
        String query = "INSERT INTO Ingredientes (Nome,Unidade_medida,ID_prato,ID_bebida) VALUES (?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setString(1, ingrediente.getNome());
            stmt.setString(2, ingrediente.getUnidade_medida());
            stmt.setInt(3, ingrediente.getID_prato());
            stmt.setInt(4, ingrediente.getID_bebida());
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<ingredientes> readAll() {
        List<ingredientes> ingrediente = new ArrayList<>();
        String query = "SELECT * FROM Ingredientes";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                ingrediente.add(new ingredientes(rs.getString("Nome"),rs.getString("Unidade_medida"),rs.getInt("ID_prato"),rs.getInt("ID_bebida")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ingrediente;
    }
   
    public void update(ingredientes ingrediente, int id) {
       
        String query = "UPDATE Ingredientes SET Nome = ?, Unidade_medida = ?, ID_prato = ?, ID_bebida = ? WHERE ID_ingrediente = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            
            stmt.setString(1, ingrediente.getNome());
            stmt.setString(2, ingrediente.getUnidade_medida());
            stmt.setInt(3, ingrediente.getID_prato());
            stmt.setInt(4, ingrediente.getID_bebida());
                    
            stmt.setInt(5,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Ingredientes WHERE ID_ingrediente = ?";
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