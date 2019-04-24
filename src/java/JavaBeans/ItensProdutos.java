package JavaBeans;

public class ItensProdutos {
    private Vendas vendas;
    private Produto produto;

    public ItensProdutos() {
    }

    public ItensProdutos(Vendas vendas, Produto produto ) {
        this.vendas = vendas;
        this.produto = produto;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
