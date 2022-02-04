package git.desafioalexey.pizzaria.dtos.responses.pizzaResponses;

import git.desafioalexey.pizzaria.models.Pizza;

public class PizzaResponseDTO {
    private Long codigo;
    private String sabor;
    private String tipo;
    private Double preco;

    public PizzaResponseDTO covertToPizzaDTO(Pizza pizzaCriada) {
        PizzaResponseDTO pizzaResponsDTO = new PizzaResponseDTO();
        pizzaResponsDTO.setCodigo(pizzaCriada.getId());
        pizzaResponsDTO.setSabor(pizzaCriada.getSabor());
        pizzaResponsDTO.setTipo(pizzaCriada.getTipo());
        pizzaResponsDTO.setPreco(pizzaCriada.getPreco());

        return pizzaResponsDTO;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
