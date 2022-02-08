package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.mapper.ClienteMapper;
import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.ClienteRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteResponseDTO criar(ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteCriado = clienteMapper.toCliente(clienteRequestDTO);

        clienteRepository.save(clienteCriado);

        return clienteMapper.toClienteDTO(clienteCriado);
    }

    public ClienteResponseDTO atualizar(ClienteRequestDTO clienteRequestDTO, Long id) {
        Cliente clienteEncotrado = clienteRepository.findById(id).get();

        clienteMapper.atualizar(clienteRequestDTO, clienteEncotrado);

        clienteRepository.save(clienteEncotrado);

        return clienteMapper.toClienteDTO(clienteEncotrado);
    }

    public List<GetClienteResponse> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            getClienteResponses.add(clienteMapper.toClienteGetDTO(cliente));
        }

        return getClienteResponses;
    }

    public GetClienteResponse listarPorId(Long id) {
        Cliente clienteEncontrado = clienteRepository.findById(id).get();

        return clienteMapper.toClienteGetDTO(clienteEncontrado);
    }

    public List<GetClienteResponse> listarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeIsContaining(nome);

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            getClienteResponses.add(clienteMapper.toClienteGetDTO(cliente));
        }

        return  getClienteResponses;
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
