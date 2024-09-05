package tabelas;

import java.util.Date;

public class entrega{
    private int ID_entrega;
    private String Endereco;
    private int ID_pedido;
    private Date Data_entrega;
    
    public entrega(String Endereco, int ID_pedido, Date Data_entrega){
        this.Endereco = Endereco;
        this.ID_pedido = ID_pedido;
        this.Data_entrega = Data_entrega;
    }

    public int getID_entrega() {
        return ID_entrega;
    }

    public void setID_entrega(int ID_entrega) {
        this.ID_entrega = ID_entrega;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getID_pedido() {
        return ID_pedido;
    }

    public void setID_pedido(int ID_pedido) {
        this.ID_pedido = ID_pedido;
    }

    public Date getData_entrega() {
        return Data_entrega;
    }

    public void setData_entrega(Date Data_entrega) {
        this.Data_entrega = Data_entrega;
    }
}