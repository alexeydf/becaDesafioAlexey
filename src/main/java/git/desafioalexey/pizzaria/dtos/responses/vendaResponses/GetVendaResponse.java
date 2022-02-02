package git.desafioalexey.pizzaria.dtos.responses.vendaResponses;

import git.desafioalexey.pizzaria.models.ItemVenda;

import java.util.ArrayList;
import java.util.List;

public class GetVendaResponse {
    private Double valorTotal;
    private String nomeCliente;
    private List<ItemVenda> itens = new ArrayList<>();

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
