package tabelas;

public class bebidas{
    private int ID_bebida;
    private String Nome;
    private String Descricao;
    private double Valor;
    
    public bebidas (String Nome, String Descricao, double Valor){
        this.ID_bebida = ID_bebida;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Valor = Valor;
    }

    public int getID_bebida() {
        return ID_bebida;
    }

    public void setID_bebida(int ID_bebida) {
        this.ID_bebida = ID_bebida;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
}