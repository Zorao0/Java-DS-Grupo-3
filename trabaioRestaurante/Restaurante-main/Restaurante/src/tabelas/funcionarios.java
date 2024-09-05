package tabelas;

import java.util.Date;

public class funcionarios{
    private int ID_func;
    private String CPF;
    private String Nome;
    private String Sexo;
    private String Idade;
    private String Endereco;
    private String Email;
    private String Telefone;
    private int ID_filial;
    private String Cargo;
    private Date Data_contratacao;

    public funcionarios (String CPF,String Nome,String Sexo,String Idade,String Endereco,String Email,String Telefone,int ID_filial, String Cargo, Date Data_contratacao){
        this.ID_func = ID_func;
        this.CPF = CPF;
        this.Nome = Nome;
        this.Sexo = Sexo;
        this.Idade = Idade;
        this.Endereco = Endereco;
        this.Email = Email;
        this.Telefone = Telefone;
        this.ID_filial = ID_filial;
        this.Cargo = Cargo;
        this.Data_contratacao = Data_contratacao;
    }

    public int getID_func() {
        return ID_func;
    }

    public void setID_func(int ID_func) {
        this.ID_func = ID_func;
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

    public int getID_filial() {
        return ID_filial;
    }

    public void setID_filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Date getData_contratacao() {
        return Data_contratacao;
    }

    public void setData_contratacao(Date Data_contratacao) {
        this.Data_contratacao = Data_contratacao;
    }
}