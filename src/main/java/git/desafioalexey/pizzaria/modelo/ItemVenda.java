package git.desafioalexey.pizzaria.modelo;

public class ItemVenda {

    private Long id;
    private Pizza pizza;
    private Integer quantidade;
    private Double preco;

    public ItemVenda() {
    }

    public ItemVenda(Long id, Pizza pizza, Integer quantidade, Double preco) {
        this.id = id;
        this.pizza = pizza;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getValorTotal() {
        return this.preco * this.quantidade;
    }
}
