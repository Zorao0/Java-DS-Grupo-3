package conexao;

import tabelas.fornecedores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFornecedores {
    
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

    public void create(fornecedores fornecedor) {
        
        String query = "INSERT INTO Fornecedores (Nome,CNPJ,Tipo_material,Email,Telefone,Valor_material) VALUES (?,?,?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCNPJ());
            stmt.setString(3, fornecedor.getTipo_material());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setDouble(6, fornecedor.getValor_material());
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<fornecedores> readAll() {
        List<fornecedores> fornecedor = new ArrayList<>();
        String query = "SELECT * FROM Fornecedores";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                fornecedor.add(new fornecedores(
                rs.getString("Nome"),
                rs.getString("CNPJ"),
                rs.getString("Tipo_material"),
                rs.getString("Email"),
                rs.getString("Telefone"),
                rs.getDouble("Valor_material")
                ));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return fornecedor;
    }

   
    public void update(fornecedores fornecedor, int id) {
       
        String query = "UPDATE Fornecedores SET Nome = ?,CNPJ = ?, Tipo_material = ?, Email = ?, Telefone = ?, Valor_material = ? WHERE ID_reserva = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCNPJ());
            stmt.setString(3, fornecedor.getTipo_material());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setDouble(6, fornecedor.getValor_material());
                    
            stmt.setInt(7,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Fornecedores WHERE ID_reserva = ?";
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