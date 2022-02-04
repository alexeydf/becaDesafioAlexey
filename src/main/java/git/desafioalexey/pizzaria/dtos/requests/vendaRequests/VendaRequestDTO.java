package git.desafioalexey.pizzaria.dtos.requests.vendaRequests;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Venda;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class VendaRequestDTO {
    @NotNull(message = "{campo.not.blank}")
    private Long clienteId;

    @NotEmpty(message = "{campo.not.blank}")
    private List<ItemVenda> itens = new ArrayList<>();

    private Double valorTotal;

    public Integer getQuantidadeTotal() {
        Integer quantidadeTotal = 0;

        for (ItemVenda item: this.itens) {
            quantidadeTotal += item.getQuantidade();
        }

        return quantidadeTotal;
    }

    public Double getValorTotal() {
        Double valorTotalCalculado = 0.0;

        for (ItemVenda item: this.itens) {
            valorTotalCalculado += item.getValorTotal();
        }

        this.valorTotal = valorTotalCalculado;

        return this.valorTotal;
    }
}
