package tabelas;

public class filiais{
    private int ID_filial;
    private String Endereco;
    private String Email;
    private String Telefone;
    private int Quant_mesas;
    private double Avaliacao;

    public filiais (String Endereco, String Email, String Telefone, int Quant_mesas, double Avaliacao) {
        this.ID_filial = ID_filial;
        this.Endereco = Endereco;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Quant_mesas = Quant_mesas;
        this.Avaliacao = Avaliacao;
    }

    public int getID_filial() {
        return ID_filial;
    }

    public void setID_filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public int getQuant_mesas() {
        return Quant_mesas;
    }

    public void setQuant_mesas(int Quant_mesas) {
        this.Quant_mesas = Quant_mesas;
    }

    public double getAvaliacao() {
        return Avaliacao;
    }

    public void setAvaliacao(double Avaliacao) {
        this.Avaliacao = Avaliacao;
    }
}