package git.desafioalexey.pizzaria.dtos.requests.pizzaRequests;

import git.desafioalexey.pizzaria.models.Pizza;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PizzaRequestDTO {
    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 3, max = 30, message = "{min.caracter}")
    private String sabor;

    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 3, max = 30, message = "{min.caracter}")
    private String tipo;

    @NotNull(message = "{campo.not.blank}")
    @Min(value = 0, message = "{preco.min.valor}")
    private Double preco;

    public Pizza convertToPizza(PizzaRequestDTO pizzaRequestDTO, Pizza pizza) {
        pizza.setSabor(pizzaRequestDTO.getSabor());
        pizza.setTipo(pizzaRequestDTO.getTipo());
        pizza.setPreco(pizzaRequestDTO.getPreco());

        return pizza;
    }

}
