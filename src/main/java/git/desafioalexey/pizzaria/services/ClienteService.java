package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ClienteService implements CrudInterface<Cliente> {
    @Override
    public Cliente criar(Cliente cliente) {
        if(cliente.getNome().length() < 3) {
            throw new RuntimeException("O nome deve conter 3 ou mais caractéres!");
        }

        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        cliente.setId(Long.valueOf(numeroAleatorio));

        return cliente;
    }

    @Override
    public Cliente atualizar(Cliente cliente, Long id) {
        cliente.setId(id);

        return cliente;
    }

    @Override
    public List<Cliente> listarTodos() {
        Cliente cliente1 = new Cliente(1L,"Alexey", "Qi 06 cj z 32", "61 983122366", "ale@g.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Qi 06 cj z 32", "61 955665566", "ale@g.com");
        Cliente cliente3 = new Cliente(3L,"Victor", "Qi 06 cj z 32", "61 983122366", "ale@g.com");

        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);

        return clientes;
    }

    @Override
    public Cliente listarPorId(Long id) {
        Cliente cliente = new Cliente(id,"Alexey Braga", "Qi 06 cj z 32", "61 983122366", "ale@g.com");

        return cliente;
    }

    public Cliente listarPorNome(String nome) {
        Cliente cliente1 = new Cliente(1L,"Alexey", "Qi 06 cj z 32", "61 983122366", "ale@g.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Qi 06 cj z 32", "61 955665566", "ale@g.com");
        Cliente cliente3 = new Cliente(3L,"Victor", "Qi 06 cj z 32", "61 983122366", "ale@g.com");

        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);

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
        //
    }
}
