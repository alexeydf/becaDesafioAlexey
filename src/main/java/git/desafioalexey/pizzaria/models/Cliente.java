package git.desafioalexey.pizzaria.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Integer comprasRealizadas;
    private Double totalGasto;
    private LocalDate dataCadastro;

    public Cliente() {
        this.dataCadastro = LocalDate.now();
        this.totalGasto = 0.0;
        this.comprasRealizadas = 0;
    }
}
