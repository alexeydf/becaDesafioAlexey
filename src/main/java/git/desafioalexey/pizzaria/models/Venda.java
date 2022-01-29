package git.desafioalexey.pizzaria.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;
    private Date data;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<ItemVenda> itens;

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

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
