package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements CrudInterface<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente criar(Cliente cliente) {
        if(cliente.getNome().length() < 3) {
            throw new RuntimeException("O nome deve conter 3 letras ou mais!");
        }

        return clienteRepository.save(cliente);
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
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarPorId(Long id) {
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> listarPorNome(String nome) {


        /*for (Cliente cliente: clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                Cliente clientePesquisado = cliente;
                return clientePesquisado;
            }
        }*/

        //throw new RuntimeException("Cliente não encontrado!");

        return  clienteRepository.findByNomeContains(nome);
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
