package git.desafioalexey.pizzaria.modelo;

public class Pizza {

    private Long id;
    private String sabor;
    private String tipo;
    private Double preco;

    public Pizza() {
    }

    public Pizza(String sabor, String tipo, Double preco) {
        this.sabor = sabor;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
