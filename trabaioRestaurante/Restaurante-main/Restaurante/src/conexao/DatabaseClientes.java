package conexao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.clientes;

public class DatabaseClientes {
    
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

    public void create(clientes cliente) {
        
        String query = "INSERT INTO Clientes (CPF,Nome,Sexo,Idade,Endereco,Email,Telefone,Data_cadastro) VALUES (?,?,?,?,?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, cliente.getCPF());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getSexo());
            stmt.setString(4, cliente.getIdade());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getTelefone());
            
            Date utilDate = cliente.getData_cadastro();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(8, sqlDate);
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<clientes> readAll() {
        List<clientes> cliente = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                cliente.add(new clientes(
                    rs.getString("CPF"),
                    rs.getString("Nome"),
                    rs.getString("Sexo"),
                    rs.getString("Idade"),
                    rs.getString("Endereco"),
                    rs.getString("Email"),
                    rs.getString("Telefone"),
                    rs.getDate("Data_cadastro")
                ));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return cliente;
    }

   
    public void update(clientes func, int id) {
       
        String query = "UPDATE Clientes SET CPF = ?, Nome = ?, Sexo = ?, Idade = ?, Endereco = ?, Email = ?, Telefone = ?, ID_filial = ?, Data_cadastro = ? WHERE ID_cliente = ?";
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
            
            Date utilDate = func.getData_cadastro();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(8, sqlDate);
            
            stmt.setInt(9,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Clientes WHERE ID_func = ?";
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