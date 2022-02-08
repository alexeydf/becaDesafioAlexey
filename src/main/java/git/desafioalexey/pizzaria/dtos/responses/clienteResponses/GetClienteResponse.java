package git.desafioalexey.pizzaria.dtos.responses.clienteResponses;

import git.desafioalexey.pizzaria.models.Cliente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetClienteResponse {
    private Long codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Integer comprasRealizadas;
    private Double totalGasto;
    private LocalDate dataCadastro;

}
