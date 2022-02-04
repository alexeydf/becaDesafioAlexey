package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.mapper.ClienteMapper;
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

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO criar(ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteCriado = clienteMapper.convertToCliente(clienteRequestDTO);
        clienteRepository.save(clienteCriado);

        ClienteResponseDTO clienteResponseDTO = clienteMapper.convertToClienteDTO(clienteCriado);

        return clienteResponseDTO;
    }

    public ClienteResponseDTO atualizar(ClienteRequestDTO clienteRequestDTO, Long id) {
        Cliente clienteEncotrado = clienteRepository.findById(id).get();

        clienteRequestDTO.convertToCliente(clienteRequestDTO, clienteEncotrado);

        clienteRepository.save(clienteEncotrado);

        ClienteResponseDTO clienteResponseDTO = clienteMapper.convertToClienteDTO(clienteEncotrado);

        return clienteResponseDTO;
    }

    public List<GetClienteResponse> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            GetClienteResponse getClienteResponse = clienteMapper.corvertToGetDTO(cliente);

            getClienteResponses.add(getClienteResponse);
        }

        return getClienteResponses;
    }

    public GetClienteResponse listarPorId(Long id) {
        Cliente clienteEncontrado = clienteRepository.findById(id).get();

        GetClienteResponse getClienteResponse = clienteMapper.corvertToGetDTO(clienteEncontrado);

        return getClienteResponse;
    }

    public List<GetClienteResponse> listarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeIsContaining(nome);

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            GetClienteResponse getClienteResponse = clienteMapper.corvertToGetDTO(cliente);

            getClienteResponses.add(getClienteResponse);
        }

        return  getClienteResponses;
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
