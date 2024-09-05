package tabelas;

import java.util.Date;

public class clientes{
    private int ID_cliente;
    private String CPF;
    private String Nome;
    private String Sexo;
    private String Idade;
    private String Endereco;
    private String Email;
    private String Telefone;
    private Date Data_cadastro;
    
    public clientes (String CPF, String Nome, String Sexo, String Idade, String Endereco, String Email, String Telefone, Date Data_cadastro){
        this.ID_cliente = ID_cliente;
        this.CPF = CPF;
        this.Nome = Nome;
        this.Sexo = Sexo;
        this.Idade = Idade;
        this.Endereco = Endereco;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Data_cadastro = Data_cadastro;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
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

    public Date getData_cadastro() {
        return Data_cadastro;
    }

    public void setData_cadastro(Date Data_cadastro) {
        this.Data_cadastro = Data_cadastro;
    }
}