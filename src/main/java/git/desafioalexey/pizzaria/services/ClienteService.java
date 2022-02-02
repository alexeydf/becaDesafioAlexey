package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.PachClienteRequest;
import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.PostClienteRequest;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.PatchClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.PostClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.GetPizzaResponse;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public PostClienteResponse criar(PostClienteRequest postClienteRequest) {
        if(postClienteRequest.getNome().length() < 3) {
            throw new RuntimeException("O nome deve conter 3 letras ou mais!");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(postClienteRequest.getNome());
        cliente.setEndereco(postClienteRequest.getEndereco());
        cliente.setTelefone(postClienteRequest.getTelefone());
        cliente.setEmail(postClienteRequest.getEmail());

        Cliente clienteCriado = clienteRepository.save(cliente);

        PostClienteResponse postClienteResponse = new PostClienteResponse();
        postClienteResponse.setCodigo(clienteCriado.getId());
        postClienteResponse.setNome(clienteCriado.getNome());
        postClienteResponse.setEndereco(clienteCriado.getEndereco());
        postClienteResponse.setEmail(clienteCriado.getEmail());
        postClienteResponse.setTelefone(clienteCriado.getTelefone());
        postClienteResponse.setMensagem("Cliente cadastrado com sucesso.");

        return postClienteResponse;
    }

    public PatchClienteResponse atualizar(PachClienteRequest pachClienteRequest, Long id) {
        Cliente clienteEncotrado = clienteRepository.findById(id).get();

        clienteEncotrado.setNome(pachClienteRequest.getNome());
        clienteEncotrado.setEndereco(pachClienteRequest.getEndereco());
        clienteEncotrado.setEmail(pachClienteRequest.getEmail());
        clienteEncotrado.setTelefone(pachClienteRequest.getTelefone());

        clienteRepository.save(clienteEncotrado);

        PatchClienteResponse patchClienteResponse = new PatchClienteResponse();
        patchClienteResponse.setCodigo(clienteEncotrado.getId());
        patchClienteResponse.setNome(clienteEncotrado.getNome());
        patchClienteResponse.setEmail(clienteEncotrado.getEmail());
        patchClienteResponse.setEndereco(clienteEncotrado.getEndereco());
        patchClienteResponse.setTelefone(clienteEncotrado.getTelefone());
        patchClienteResponse.setMensagem("O registro " + patchClienteResponse.getCodigo() + " foi atualizado com sucesso.");


        return patchClienteResponse;
    }

    public List<GetClienteResponse> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            GetClienteResponse getClienteResponse = new GetClienteResponse();

            getClienteResponse.setCodigo(cliente.getId());
            getClienteResponse.setEmail(cliente.getEmail());
            getClienteResponse.setEndereco(cliente.getEndereco());
            getClienteResponse.setNome(cliente.getNome());
            getClienteResponse.setTelefone(cliente.getTelefone());
            getClienteResponse.setComprasRealizadas(cliente.getComprasRealizadas());
            getClienteResponse.setTotalGasto(cliente.getTotalGasto());
            getClienteResponse.setDataCadastro(cliente.getDataCadastro());

            getClienteResponses.add(getClienteResponse);
        }

        return getClienteResponses;
    }

    public GetClienteResponse listarPorId(Long id) {
        Cliente clienteEncontrado = clienteRepository.findById(id).get();

        GetClienteResponse getClienteResponse = new GetClienteResponse();
        getClienteResponse.setCodigo(clienteEncontrado.getId());
        getClienteResponse.setEmail(clienteEncontrado.getEmail());
        getClienteResponse.setEndereco(clienteEncontrado.getEndereco());
        getClienteResponse.setNome(clienteEncontrado.getNome());
        getClienteResponse.setTelefone(clienteEncontrado.getTelefone());
        getClienteResponse.setComprasRealizadas(clienteEncontrado.getComprasRealizadas());
        getClienteResponse.setTotalGasto(clienteEncontrado.getTotalGasto());
        getClienteResponse.setDataCadastro(clienteEncontrado.getDataCadastro());

        return getClienteResponse;
    }

    public List<GetClienteResponse> listarPorNome(String nome) {

        List<Cliente> clientes = clienteRepository.findByNomeIsContaining(nome);

        List<GetClienteResponse> getClienteResponses = new ArrayList<>();

        for (Cliente cliente: clientes) {
            GetClienteResponse getClienteResponse = new GetClienteResponse();

            getClienteResponse.setCodigo(cliente.getId());
            getClienteResponse.setEmail(cliente.getEmail());
            getClienteResponse.setEndereco(cliente.getEndereco());
            getClienteResponse.setNome(cliente.getNome());
            getClienteResponse.setTelefone(cliente.getTelefone());
            getClienteResponse.setComprasRealizadas(cliente.getComprasRealizadas());
            getClienteResponse.setTotalGasto(cliente.getTotalGasto());
            getClienteResponse.setDataCadastro(cliente.getDataCadastro());

            getClienteResponses.add(getClienteResponse);
        }


        return  getClienteResponses;
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
