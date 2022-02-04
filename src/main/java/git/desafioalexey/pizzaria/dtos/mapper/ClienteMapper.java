package git.desafioalexey.pizzaria.dtos.mapper;

import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.ClienteRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.models.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    /*Pizza convertToPizza(PizzaRequestDTO pizzaRequestDTO);

    @InheritInverseConfiguration
    @Mapping(target = "codigo", source = "id")
    PizzaResponseDTO convertToPizzaDTO(Pizza pizza);*/

    Cliente convertToCliente(ClienteRequestDTO clienteRequestDTO);

    @InheritInverseConfiguration
    @Mapping(target = "codigo", source = "id")
    ClienteResponseDTO convertToClienteDTO(Cliente cliente);

    @Mapping(target = "codigo", source = "id")
    GetClienteResponse corvertToGetDTO(Cliente cliente);
}
