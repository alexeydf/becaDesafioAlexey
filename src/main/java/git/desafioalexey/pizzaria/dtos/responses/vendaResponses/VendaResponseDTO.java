package git.desafioalexey.pizzaria.dtos.responses.vendaResponses;

import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Venda;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendaResponseDTO {
    private Double valorTotal;
    private Integer quantidadeTotal;
    private String clienteNome;
    private List<ItemVenda> itens = new ArrayList<>();
}
