package conexao;

import tabelas.filiais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFiliais {
    
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

    public void create(filiais filial) {
        
        String query = "INSERT INTO Filiais (Endereco,Email,Telefone,Quant_mesas,Avaliacao) VALUES (?,?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, filial.getEndereco());
            stmt.setString(2, filial.getEmail());
            stmt.setString(3, filial.getTelefone());
            stmt.setInt(4, filial.getQuant_mesas());
            stmt.setDouble(5, filial.getAvaliacao());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<filiais> readAll() {
        List<filiais> filial = new ArrayList<>();
        String query = "SELECT * FROM Filiais";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                filial.add(new filiais(
                    rs.getString("Endereco"), 
                    rs.getString("Email"),
                    rs.getString("Telefone"),
                    rs.getInt("Quant_mesas"),
                    rs.getDouble("Avaliacao")));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return filial;
    }

   
    public void update(filiais filial, int id) {
       
        String query = "UPDATE Filiais SET Endereco = ?, Email = ?, Telefone = ?, Quant_mesas = ?, Avaliacao = ? WHERE ID_filial = ?";
        try (
           
            Connection conn = getConnection();
           
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, filial.getEndereco());
            stmt.setString(2, filial.getEmail());
            stmt.setString(3, filial.getTelefone());
            stmt.setInt(4, filial.getQuant_mesas());
            stmt.setDouble(5, filial.getAvaliacao());
            stmt.setInt(6,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Filiais WHERE ID_filial= ?";
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