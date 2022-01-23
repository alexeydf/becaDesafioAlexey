package git.desafioalexey.pizzaria.controller;

import git.desafioalexey.pizzaria.modelo.Cliente;
import git.desafioalexey.pizzaria.modelo.Pizza;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {

        if(cliente.getNome().length() < 3) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        cliente.setId(Long.valueOf(numeroAleatorio));
        cliente.setDataCadastro(new Date());
        cliente.setTotalGasto(0.00);
        cliente.setComprasRealizadas(0);

        return ResponseEntity.created(null).body(cliente);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizarCadastro(@RequestBody Cliente cliente, @PathVariable Long id) {

        cliente.setId(id);

        return ResponseEntity.ok(cliente);

    }

    @GetMapping("/listar/id/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {

        Cliente cliente = new Cliente(id,"Alexey Braga", "Qi 06 cj z 32", "61 983122366", "ale@g.com");
        cliente.setComprasRealizadas(0);
        cliente.setTotalGasto(0.0);

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar/nome/{nome}")
    public ResponseEntity<Cliente> listarPorNome(@PathVariable String nome) {
        Cliente cliente1 = new Cliente(1L,"Alexey", "Qi 06 cj z 32", "61 983122366", "ale@g.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Qi 06 cj z 32", "61 955665566", "ale@g.com");
        Cliente cliente3 = new Cliente(3L,"Victor", "Qi 06 cj z 32", "61 983122366", "ale@g.com");

        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);

        for (Cliente cliente: clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                Cliente saborPesquisado = cliente;
                return ResponseEntity.ok(saborPesquisado);
            }
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarTodos(){

        Cliente cliente1 = new Cliente(1L,"Alexey", "Qi 06 cj z 32", "61 983122366", "ale@g.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Qi 06 cj z 32", "61 955665566", "ale@g.com");
        Cliente cliente3 = new Cliente(3L,"Victor", "Qi 06 cj z 32", "61 983122366", "ale@g.com");

        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);

        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
