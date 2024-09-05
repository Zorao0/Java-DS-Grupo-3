package tabelas;

import java.util.Date;

public class fornecedores{
    private String Nome;
    private int ID_fornecedor;
    private String CNPJ;
    private String Tipo_material;
    private String Email;
    private String Telefone;
    private Double Valor_material;
    
    public fornecedores (String Nome, String CNPJ, String Tipo_material, String Email, String Telefone, Double Valor_material){
        this.Nome = Nome;
        this.CNPJ = CNPJ;
        this.Tipo_material = Tipo_material;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Valor_material = Valor_material;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getID_fornecedor() {
        return ID_fornecedor;
    }

    public void setID_fornecedor(int ID_fornecedor) {
        this.ID_fornecedor = ID_fornecedor;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTipo_material() {
        return Tipo_material;
    }

    public void setTipo_material(String Tipo_material) {
        this.Tipo_material = Tipo_material;
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

    public Double getValor_material() {
        return Valor_material;
    }

    public void setValor_material(Double Valor_material) {
        this.Valor_material = Valor_material;
    }
    
}