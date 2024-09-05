package tabelas;

public class estoque{
    private int ID_fornecedor;
    private int ID_materia;
    private int Quantidade;
    private int ID_filial;
    
    public estoque (int ID_fornecedor, int Quantidade, int ID_filial){
        this.ID_fornecedor = ID_fornecedor;
        this.Quantidade = Quantidade;
        this.ID_filial = ID_filial;
    }

    public int getID_fornecedor() {
        return ID_fornecedor;
    }

    public void setID_fornecedor(int ID_fornecedor) {
        this.ID_fornecedor = ID_fornecedor;
    }

    public int getID_materia() {
        return ID_materia;
    }

    public void setID_materia(int ID_materia) {
        this.ID_materia = ID_materia;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public int getID_filial() {
        return ID_filial;
    }

    public void setID_filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }
}