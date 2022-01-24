package git.desafioalexey.pizzaria.modelo;

import java.util.Date;
import java.util.List;

public class Venda {

    private Long id;
    private Double valorTotal;
    private Date data;
    private Cliente cliente;
    private List<ItemVenda> itens;

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Venda() {
    }

    public Venda(Long id, Date data, Cliente cliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.data = data;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
