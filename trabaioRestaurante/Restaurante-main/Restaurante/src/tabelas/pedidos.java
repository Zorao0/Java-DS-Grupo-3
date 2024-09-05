package tabelas;

import java.util.Date;

public class pedidos{
    private int ID_pedido;
    private int ID_cliente;
    private int ID_prato;
    private int ID_bebida;
    private double Valor;
    private String Tipo_pagamento;
    private String Endereco;
    private Date Data_pedido;
    
    public pedidos (int ID_cliente,int ID_prato,int ID_bebida,double Valor,String Tipo_pagamento,String Endereco,Date Data_pedido){
        this.ID_cliente = ID_cliente;
        this.ID_prato = ID_prato;
        this.ID_bebida = ID_bebida;
        this.Valor = Valor;
        this.Tipo_pagamento = Tipo_pagamento;
        this.Endereco = Endereco;
        this.Data_pedido = Data_pedido;
    }

    public int getID_pedido() {
        return ID_pedido;
    }

    public void setID_pedido(int ID_pedido) {
        this.ID_pedido = ID_pedido;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public int getID_prato() {
        return ID_prato;
    }

    public void setID_prato(int ID_prato) {
        this.ID_prato = ID_prato;
    }

    public int getID_bebida() {
        return ID_bebida;
    }

    public void setID_bebida(int ID_bebida) {
        this.ID_bebida = ID_bebida;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getTipo_pagamento() {
        return Tipo_pagamento;
    }

    public void setTipo_pagamento(String Tipo_pagamento) {
        this.Tipo_pagamento = Tipo_pagamento;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public Date getData_pedido() {
        return Data_pedido;
    }

    public void setData_pedido(Date Data_pedido) {
        this.Data_pedido = Data_pedido;
    }
}