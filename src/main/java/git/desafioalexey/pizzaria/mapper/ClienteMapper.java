package git.desafioalexey.pizzaria.mapper;

import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.ClienteRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toCliente(ClienteRequestDTO clienteRequestDTO);

    void atualizar(ClienteRequestDTO clienteRequestDTO,@MappingTarget Cliente cliente);

    @Mapping(target = "codigo", source = "id")
    ClienteResponseDTO toClienteDTO(Cliente cliente);

    @Mapping(target = "codigo", source = "id")
    GetClienteResponse toClienteGetDTO(Cliente cliente);
}
