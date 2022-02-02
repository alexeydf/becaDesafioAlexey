package git.desafioalexey.pizzaria.dtos.requests.pizzaRequests;

public class PostPizzaRequest {
    private String sabor;
    private String tipo;
    private Double preco;

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
