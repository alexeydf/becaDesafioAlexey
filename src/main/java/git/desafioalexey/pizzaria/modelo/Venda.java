package git.desafioalexey.pizzaria.modelo;

import java.util.Date;

public class Venda {

    private Long id;
    private Integer quantidadeComprada;
    private Double valorTotalPago;
    private Date dataVenda;
    private Cliente cliente;

    public Venda() {
    }

    public Venda(Integer quantidadeComprada, Double valorTotalPago, Date dataVenda, Cliente cliente) {
        this.quantidadeComprada = quantidadeComprada;
        this.valorTotalPago = valorTotalPago;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(Integer quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public Double getValorTotalPago() {
        return valorTotalPago;
    }

    public void setValorTotalPago(Double valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
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
