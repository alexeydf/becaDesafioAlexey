package git.desafioalexey.pizzaria.dtos.responses.clienteResponses;

import git.desafioalexey.pizzaria.models.Cliente;

public class ClienteResponseDTO {
    private Long codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String mensagem;

    public ClienteResponseDTO convertToClienteDTO(Cliente cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setCodigo(cliente.getId());
        clienteResponseDTO.setNome(cliente.getNome());
        clienteResponseDTO.setEndereco(cliente.getEndereco());
        clienteResponseDTO.setEmail(cliente.getEmail());
        clienteResponseDTO.setTelefone(cliente.getTelefone());
        clienteResponseDTO.setMensagem("Cliente cadastrado com sucesso.");

        return clienteResponseDTO;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
