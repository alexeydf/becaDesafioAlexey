package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ClienteService implements CrudInterface<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente criar(Cliente cliente) {
        if(cliente.getNome().length() < 3) {
            throw new RuntimeException("O nome deve conter 3 letras ou mais!");
        }

        Cliente clienteCriado = clienteRepository.save(cliente);

        return clienteCriado;
    }

    @Override
    public Cliente atualizar(Cliente cliente, Long id) {
        Cliente clienteEncotrado = clienteRepository.findById(id).get();

        clienteEncotrado.setNome(cliente.getNome());
        clienteEncotrado.setEndereco(cliente.getEndereco());
        clienteEncotrado.setEmail(cliente.getEmail());
        clienteEncotrado.setTelefone(cliente.getTelefone());

        clienteRepository.save(clienteEncotrado);

        return clienteEncotrado;
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }

    @Override
    public Cliente listarPorId(Long id) {
        Cliente clienteListado = clienteRepository.findById(id).get();

        return clienteListado;
    }

    public Cliente listarPorNome(String nome) {
        List<Cliente> clientes = clienteRepository.findAll();

        for (Cliente cliente: clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                Cliente clientePesquisado = cliente;
                return clientePesquisado;
            }
        }

        throw new RuntimeException("Cliente não encontrado!");
    }

    @Override
    public void excluir(Long id) {
        Cliente clienteLocalizado = clienteRepository.findById(id).get();

        clienteRepository.delete(clienteLocalizado);
    }
}
