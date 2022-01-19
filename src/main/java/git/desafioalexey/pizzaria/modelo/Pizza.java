package git.alexeydf.pizzaria.modelo;

public class Pizza {

    private Long id;
    private String sabor;
    private String tipo;
    private Double preco;
    private Integer quantidadeVendida;
    private Double totalArrecadado;

    public Pizza() {
    }

    public Pizza(String sabor, String tipo, Double preco) {
        this.sabor = sabor;
        this.tipo = tipo;
        this.preco = preco;
    }
}
