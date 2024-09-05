package tabelas;

import java.util.Date;

public class reservas{
    private int ID_reserva;
    private Date Data_reserva;
    private int ID_cliente;
    private String Mesa;
    private int ID_filial;
    private String Capacidade;
    
    public reservas (Date Data_reserva,int ID_cliente, String Mesa, int ID_filial, String Capacidade){
        this.Data_reserva = Data_reserva;
        this.ID_cliente = ID_cliente;
        this.Mesa = Mesa;
        this.ID_filial = ID_filial;
        this.Capacidade = Capacidade;
    }

    public int getID_reserva() {
        return ID_reserva;
    }

    public void setID_reserva(int ID_reserva) {
        this.ID_reserva = ID_reserva;
    }

    public Date getData_reserva() {
        return Data_reserva;
    }

    public void setData_reserva(Date Data_reserva) {
        this.Data_reserva = Data_reserva;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public String getMesa() {
        return Mesa;
    }

    public void setMesa(String Mesa) {
        this.Mesa = Mesa;
    }

    public int getID_filial() {
        return ID_filial;
    }

    public void setID_filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }

    public String getCapacidade() {
        return Capacidade;
    }

    public void setCapacidade(String Capacidade) {
        this.Capacidade = Capacidade;
    }
}