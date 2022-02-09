package git.desafioalexey.pizzaria.mapper;

import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PizzaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PizzaResponseDTO;
import git.desafioalexey.pizzaria.models.Pizza;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PizzaMapper {
    Pizza toPizza(PizzaRequestDTO pizzaRequestDTO);

    @Mapping(target = "codigo", source = "id")
    PizzaResponseDTO toPizzaDTO(Pizza pizza);

    void atualizar(PizzaRequestDTO pizzaRequestDTO, @MappingTarget Pizza pizza);
}
