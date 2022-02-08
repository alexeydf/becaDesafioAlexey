package git.desafioalexey.pizzaria.dtos.responses.clienteResponses;

import git.desafioalexey.pizzaria.models.Cliente;
import lombok.Data;

@Data
public class ClienteResponseDTO {
    private Long codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

}
