package git.desafioalexey.pizzaria.modelo;

public class ItemVenda {

    private Long id;
    private Cliente cliente;
    private Pizza pizza;
    private Integer quantidade;
    private Double preco;

    public ItemVenda() {
    }

    public ItemVenda(Cliente cliente, Pizza pizza, Integer quantidade, Double preco) {
        this.cliente = cliente;
        this.pizza = pizza;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
