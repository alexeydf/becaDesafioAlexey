package git.desafioalexey.pizzaria.dtos.mapper;

import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.VendaResponseDTO;
import git.desafioalexey.pizzaria.models.Venda;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    Venda convertToVenda(VendaRequestDTO vendaRequestDTO);

    VendaResponseDTO covertToVendaDTO(Venda venda);
}
