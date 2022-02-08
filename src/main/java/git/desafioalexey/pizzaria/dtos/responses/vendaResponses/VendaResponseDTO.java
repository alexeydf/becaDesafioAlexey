package git.desafioalexey.pizzaria.dtos.responses.vendaResponses;

import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaResponseDTO {
    private Double valorTotal;
    private Integer quantidadeTotal;
    private String nomeCliente;
    private List<ItemVenda> itens = new ArrayList<>();

    public VendaResponseDTO convertToVendaDTO(Venda venda) {
        VendaResponseDTO getVendaResponse = new VendaResponseDTO();

        getVendaResponse.setItens(venda.getItens());
        getVendaResponse.setNomeCliente(venda.getCliente().getNome());
        getVendaResponse.setValorTotal(venda.getValorTotal());
        getVendaResponse.setQuantidadeTotal(venda.getQuantidadeTotal());

        return getVendaResponse;
    }

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

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
}
