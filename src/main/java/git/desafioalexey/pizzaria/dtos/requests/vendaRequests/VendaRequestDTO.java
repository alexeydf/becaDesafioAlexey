package git.desafioalexey.pizzaria.dtos.requests.vendaRequests;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaRequestDTO {
    private Long clienteId;
    private List<ItemVenda> itens = new ArrayList<>();
    private Double valorTotal;

    public Venda convertToVenda(Cliente cliente, VendaRequestDTO vendaRequestDTO) {
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setItens(vendaRequestDTO.getItens());
        venda.setValorTotal(vendaRequestDTO.getValorTotal());

        return venda;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

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
