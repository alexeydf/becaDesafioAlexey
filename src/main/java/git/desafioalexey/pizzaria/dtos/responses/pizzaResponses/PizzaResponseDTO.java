package git.desafioalexey.pizzaria.dtos.responses.pizzaResponses;

import git.desafioalexey.pizzaria.models.Pizza;
import lombok.Data;

@Data
public class PizzaResponseDTO {
    private Long codigo;
    private String sabor;
    private String tipo;
    private Double preco;
}
