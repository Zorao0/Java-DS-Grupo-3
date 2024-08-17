import Classes.pessoas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Databasae {
    
    private static final String URL = "jdbc:mysql://localhost:3306/cadastroPessoas";
    private static final String USER = "seuusuario";
    private static final String PASSWORD = "suasenha";

    
    private Connection getConnection() {
        try {
           
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
           
            throw new RuntimeException(e);
        }
    }

   
    public void create(pessoas pessoa) {
        
        String query = "INSERT INTO Pessoa (cpf, nome, idade) VALUES (?, ?, ?)";
        try (
            
            Connection conn = getConnection();
           
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
           
            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setInt(3, pessoa.getIdade());
           
            stmt.execute();
        } catch (SQLException e) {
           
            throw new RuntimeException(e);
        }
    }

    
    public List<pessoas> readAll() {
        
        List<pessoas> pessoas = new ArrayList<>();
       
        String query = "SELECT * FROM Pessoa";
        try (
            
            Connection conn = getConnection();
           
            PreparedStatement stmt = conn.prepareStatement(query);
           
            ResultSet rs = stmt.executeQuery()
        ) {
           
            while (rs.next()) {
                
                pessoas.add(new pessoas(rs.getString("cpf"), rs.getString("nome"), rs.getInt("idade")));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return pessoas;
    }

   
    public void update(pessoas pessoa, int id) {
       
        String query = "UPDATE Pessoa SET nome = ?, idade = ?, cpf = ? WHERE id = ?";
        try (
           
            Connection conn = getConnection();
           
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
           
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getCpf());
            stmt.setInt(4,id);
            
            stmt.execute();
        } catch (SQLException e) {
           
            throw new RuntimeException(e);
        }
    }

  
    public void delete(int id) {
        
        String query = "DELETE FROM Pessoa WHERE id= ?";
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
}