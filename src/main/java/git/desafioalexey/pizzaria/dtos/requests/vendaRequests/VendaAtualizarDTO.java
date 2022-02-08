package git.desafioalexey.pizzaria.dtos.requests.vendaRequests;

import git.desafioalexey.pizzaria.models.ItemVenda;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class VendaAtualizarDTO {
    @NotEmpty(message = "{campo.not.blank}")
    private List<ItemVenda> itens = new ArrayList<>();

    private Double valorTotal;

    public Double getValorTotal() {
        Double valorTotalCalculado = 0.0;

        for (ItemVenda item: this.itens) {
            valorTotalCalculado += item.getValorTotal();
        }

        this.valorTotal = valorTotalCalculado;

        return this.valorTotal;
    }
}
