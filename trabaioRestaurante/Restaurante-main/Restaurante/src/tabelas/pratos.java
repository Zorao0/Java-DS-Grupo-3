package tabelas;

public class pratos{
    private int ID_prato;
    private String Nome;
    private String Descricao;
    private double Valor;
    
    public pratos (String Nome, String Descricao, double Valor){
        this.ID_prato = ID_prato;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Valor = Valor;
    }

    public int getID_prato() {
        return ID_prato;
    }

    public void setID_prato(int ID_prato) {
        this.ID_prato = ID_prato;
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