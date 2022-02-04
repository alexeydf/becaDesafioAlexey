package git.desafioalexey.pizzaria.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pizza pizza;

    private Integer quantidade;
    private Double preco;

    public Double getValorTotal() {
        return this.preco * this.quantidade;
    }
}
