package conexao;

import tabelas.pedidos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabasePedidos {
    
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

    public void create(pedidos pedido) {
        
        String query = "INSERT INTO Pedidos (ID_cliente,ID_prato,ID_bebida,Valor,Tipo_pagamento,Endereco,Data_pedido) VALUES (?,?,?,?,?,?,?)";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) { 
            stmt.setInt(1, pedido.getID_cliente());
            stmt.setInt(2, pedido.getID_prato());
            stmt.setInt(3, pedido.getID_bebida());
            stmt.setDouble(4, pedido.getValor());
            stmt.setString(5, pedido.getTipo_pagamento());
            stmt.setString(6, pedido.getEndereco());
            
            
            Date utilDate = pedido.getData_pedido();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(7, sqlDate);
            
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<pedidos> readAll() {
        List<pedidos> pedido = new ArrayList<>();
        String query = "SELECT * FROM Pedidos";
        try ( 
            Connection conn = getConnection();   
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                pedido.add(new pedidos(
                rs.getInt("ID_cliente"),
                rs.getInt("ID_prato"),
                rs.getInt("ID_bebida"),
                rs.getDouble("Valor"),
                rs.getString("Tipo_pagamento"),
                rs.getString("Endereco"),
                rs.getDate("Data_pedido")));
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
       
        return pedido;
    }

   
    public void update(pedidos pedido, int id) {
       
        String query = "UPDATE Pedidos SET ID_cliente = ?, ID_prato = ?, ID_bebida = ?, Valor = ?, Tipo_pagamento = ?,Endereco = ?, Data_pedido = ? WHERE ID_pedido = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, pedido.getID_cliente());
            stmt.setInt(2, pedido.getID_prato());
            stmt.setInt(3, pedido.getID_bebida());
            stmt.setDouble(4, pedido.getValor());
            stmt.setString(5, pedido.getTipo_pagamento());
            stmt.setString(6, pedido.getEndereco());
            
            Date utilDate = pedido.getData_pedido();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            stmt.setDate(7, sqlDate);
                    
            stmt.setInt(8,id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        
        String query = "DELETE FROM Pedidos WHERE ID_pedido = ?";
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