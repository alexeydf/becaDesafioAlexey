package git.desafioalexey.pizzaria.dtos.requests.clienteRequests;

import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;

public class ClienteRequestDTO {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Cliente convertToCliente(ClienteRequestDTO clienteRequestDTO, Cliente cliente) {

        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setEndereco(clienteRequestDTO.getEndereco());
        cliente.setTelefone(clienteRequestDTO.getTelefone());
        cliente.setEmail(clienteRequestDTO.getEmail());

        return cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
