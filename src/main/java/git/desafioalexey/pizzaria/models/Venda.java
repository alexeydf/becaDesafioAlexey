package git.desafioalexey.pizzaria.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;
    private LocalDate data;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = ALL)
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda() {
        this.data = LocalDate.now();
        this.valorTotal = valorTotal;
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
