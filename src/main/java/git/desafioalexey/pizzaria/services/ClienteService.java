package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.ClienteRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDTO criar(ClienteRequestDTO clienteRequestDTO) {
        if(clienteRequestDTO.getNome().length() < 3) {
            throw new RuntimeException("O nome deve conter 3 letras ou mais!");
        }

        Cliente clienteCriado = new Cliente();
        clienteRequestDTO.convertToCliente(clienteRequestDTO, clienteCriado);
        clienteRepository.save(clienteCriado);

        return new ClienteResponseDTO().convertToClienteDTO(clienteCriado);
    }

    public ClienteResponseDTO atualizar(ClienteRequestDTO clienteRequestDTO, Long id) {
        Cliente clienteEncotrado = clienteRepository.findById(id).get();

        clienteRequestDTO.convertToCliente(clienteRequestDTO, clienteEncotrado);

        clienteRepository.save(clienteEncotrado);

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO = clienteResponseDTO.convertToClienteDTO(clienteEncotrado);
        clienteResponseDTO.setMensagem("O registro " + clienteResponseDTO.getCodigo() + " foi atualizado com sucesso.");

        return clienteResponseDTO;
    }

    public List<GetClienteResponse> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            GetClienteResponse getClienteResponse = new GetClienteResponse().toClienteResponse(cliente);

            getClienteResponses.add(getClienteResponse);
        }

        return getClienteResponses;
    }

    public GetClienteResponse listarPorId(Long id) {
        Cliente clienteEncontrado = clienteRepository.findById(id).get();

        return new GetClienteResponse().toClienteResponse(clienteEncontrado);
    }

    public List<GetClienteResponse> listarPorNome(String nome) {

        List<Cliente> clientes = clienteRepository.findByNomeIsContaining(nome);

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            GetClienteResponse getClienteResponse = new GetClienteResponse().toClienteResponse(cliente);

            getClienteResponses.add(getClienteResponse);
        }

        return  getClienteResponses;
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
