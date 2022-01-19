package git.alexeydf.pizzaria.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Integer comprasRealizadas;
    private Double totaGasto;
    private LocalDate dataCadastro = LocalDate.now();

    public Cliente() {
    }

    public Cliente(String nome, String endereco, String telefone, String email, Integer comprasRealizadas, Double totaGasto) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.comprasRealizadas = comprasRealizadas;
        this.totaGasto = totaGasto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", comprasRealizadas=" + comprasRealizadas +
                ", totaGasto=" + totaGasto +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
