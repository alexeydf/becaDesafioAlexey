package git.desafioalexey.pizzaria.dtos.requests.pizzaRequests;

import git.desafioalexey.pizzaria.models.Pizza;

public class PizzaRequestDTO {
    private String sabor;
    private String tipo;
    private Double preco;

    public Pizza convertToPizza(PizzaRequestDTO pizzaRequestDTO, Pizza pizza) {
        pizza.setSabor(pizzaRequestDTO.getSabor());
        pizza.setTipo(pizzaRequestDTO.getTipo());
        pizza.setPreco(pizzaRequestDTO.getPreco());

        return pizza;
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
