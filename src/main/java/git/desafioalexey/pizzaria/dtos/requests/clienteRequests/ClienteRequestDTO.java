package git.desafioalexey.pizzaria.dtos.requests.clienteRequests;

import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ClienteRequestDTO {
    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 3, max = 100, message = "{nome.min.caracter}")
    private String nome;

    @NotBlank(message = "{campo.not.blank}")
    private String endereco;

    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 9, max = 20, message = "{tel.not.valid}")
    private String telefone;

    @NotBlank(message = "{campo.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    public Cliente convertToCliente(ClienteRequestDTO clienteRequestDTO, Cliente cliente) {

        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setEndereco(clienteRequestDTO.getEndereco());
        cliente.setTelefone(clienteRequestDTO.getTelefone());
        cliente.setEmail(clienteRequestDTO.getEmail());

        return cliente;
    }

}
