package JavaBeans;

import java.util.Date;

public class Vendas implements Descontos{
    private int codigo;
    private int quantidade;
    private double valorTotal;
    private Date data;
    private String funcionario;
    private String fisica;
    private String Juridica;

    public Vendas() {
    }

    public Vendas(int codigo, int quantidade, double valorTotal, Date data, String funcionario, String fisica, String Juridica) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = data;
        this.funcionario = funcionario;
        this.fisica = fisica;
        this.Juridica = Juridica;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFisica() {
        return fisica;
    }

    public void setFisica(String fisica) {
        this.fisica = fisica;
    }

    public String getJuridica() {
        return Juridica;
    }

    public void setJuridica(String Juridica) {
        this.Juridica = Juridica;
    }

    
    

/**
    public int descontoVista(){
        return (Produto.preco + this.quantidade)*Descontos.descontoVista;
    }
    
    public int ValorFinalVista(){
        return (Produto.preco + this.quantidade)-descontoVista();
    }
    
    public int descontoCredito(){
        return (Produto.preco + this.quantidade)*Descontos.descontoCredito;
    }
    
    public int ValorFinalCredito(){
        return (Produto.preco + this.quantidade)-descontoCredito();
    }*/

}
