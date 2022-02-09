package git.desafioalexey.pizzaria.mapper;

import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaAtualizarDTO;
import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.VendaResponseDTO;
import git.desafioalexey.pizzaria.models.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    Venda toVenda(VendaRequestDTO vendaRequestDTO);

    VendaResponseDTO toVendaDTO(Venda venda);

    void atualizar(VendaAtualizarDTO vendaAtualizarDTO, @MappingTarget Venda venda);
}
