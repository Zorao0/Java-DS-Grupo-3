package conexao;

import tabelas.funcionarios;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFuncionarios {
    
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

    public void create(funcionarios func) {
        
        String query = "INSERT INTO Funcionarios (CPF,Nome,Sexo,Idade,Endereco,Email,Telefone,ID_filial,Cargo,Data_contratacao) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, func.getCPF());
            stmt.setString(2, func.getNome());
            stmt.setString(3, func.getSexo());
            stmt.setString(4, func.getIdade());
            stmt.setString(5, func.getEndereco());
            stmt.setString(6, func.getEmail());
            stmt.setString(7, func.getTelefone());
            stmt.setInt(8, func.getID_filial());
            stmt.setString(9, func.getCargo());
            
            Date utilDate = func.getData_contratacao();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(10, sqlDate);
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<funcionarios> readAll() {
        List<funcionarios> func = new ArrayList<>();
        String query = "SELECT * FROM Funcionarios";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                func.add(new funcionarios(
                    rs.getString("CPF"),
                    rs.getString("Nome"),
                    rs.getString("Sexo"),
                    rs.getString("Idade"),
                    rs.getString("Endereco"),
                    rs.getString("Email"),
                    rs.getString("Telefone"),
                    rs.getInt("ID_filial"),
                    rs.getString("Cargo"),
                    rs.getDate("Data_contratacao")
                ));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return func;
    }

   
    public void update(funcionarios func, int id) {
       
        String query = "UPDATE Funcionarios SET CPF = ?, Nome = ?, Sexo = ?, Idade = ?, Endereco = ?, Email = ?, Telefone = ?, ID_filial = ?, Cargo = ?, Data_contratacao WHERE ID_func = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, func.getCPF());
            stmt.setString(2, func.getNome());
            stmt.setString(3, func.getSexo());
            stmt.setString(4, func.getIdade());
            stmt.setString(5, func.getEndereco());
            stmt.setString(6, func.getEmail());
            stmt.setString(7, func.getTelefone());
            stmt.setInt(8, func.getID_filial());
            stmt.setString(9, func.getCargo());
            
            Date utilDate = func.getData_contratacao();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(10, sqlDate);
            
            stmt.setInt(11,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Funcionarios WHERE ID_func = ?";
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