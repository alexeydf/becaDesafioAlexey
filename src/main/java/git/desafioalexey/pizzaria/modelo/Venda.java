package git.desafioalexey.pizzaria.modelo;

import java.util.Date;
import java.util.List;

public class Venda {

    private Long id;
    private Integer quantidadeTotal;
    private Double valorTotal;
    private Date dataVenda;
    private Cliente cliente;

    public Venda() {
    }

    public Venda(Long id, Integer quantidadeTotal, Double valorTotal, Date dataVenda, Cliente cliente) {
        this.id = id;
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
