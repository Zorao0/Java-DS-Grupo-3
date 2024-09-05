package conexao;

import tabelas.estoque;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseEstoque {
    
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

    public void create(estoque estoques) {
        
        String query = "INSERT INTO Estoque (ID_fornecedor,Quantidade,ID_filial) VALUES (?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setInt(1, estoques.getID_fornecedor());
            stmt.setInt(2, estoques.getQuantidade());
            stmt.setInt(3, estoques.getID_filial());
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<estoque> readAll() {
        List<estoque> func = new ArrayList<>();
        String query = "SELECT * FROM Estoque";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                func.add(new estoque(
                rs.getInt("ID_fornecedor"),rs.getInt("Quantidade"),rs.getInt("ID_filial")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return func;
    }
   
    public void update(estoque estoques, int id) {
       
        String query = "UPDATE Estoque SET ID_fornecedor = ?, Quantidade = ?, ID_filial = ? WHERE ID_materia = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            
            stmt.setInt(1, estoques.getID_fornecedor());
            stmt.setInt(2, estoques.getQuantidade());
            stmt.setInt(3, estoques.getID_filial());
                    
            stmt.setInt(4,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Estoque WHERE ID_materia = ?";
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