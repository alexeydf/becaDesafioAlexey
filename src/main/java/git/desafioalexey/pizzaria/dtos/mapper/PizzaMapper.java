package git.desafioalexey.pizzaria.dtos.mapper;

import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PizzaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PizzaResponseDTO;
import git.desafioalexey.pizzaria.models.Pizza;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PizzaMapper {
    Pizza convertToPizza(PizzaRequestDTO pizzaRequestDTO);

    @InheritInverseConfiguration
    @Mapping(target = "codigo", source = "id")
    PizzaResponseDTO convertToPizzaDTO(Pizza pizza);
}
