package tabelas;

public class ingredientes{
    private int ID_ingrediente;
    private String Nome;
    private String Unidade_medida;
    private int ID_prato;
    private int ID_bebida;
    
    public ingredientes (String Nome,String Unidade_medida, int ID_prato, int ID_bebida){
        this.Nome = Nome;
        this.Unidade_medida = Unidade_medida;
        this.ID_prato = ID_prato;
        this.ID_bebida = ID_bebida;
    }

    public int getID_ingrediente() {
        return ID_ingrediente;
    }

    public void setID_ingrediente(int ID_ingrediente) {
        this.ID_ingrediente = ID_ingrediente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getUnidade_medida() {
        return Unidade_medida;
    }

    public void setUnidade_medida(String Unidade_medida) {
        this.Unidade_medida = Unidade_medida;
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
}