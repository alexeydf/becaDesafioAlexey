package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
       Cliente clienteCriado = clienteService.criar(cliente);

        return ResponseEntity.created(null).body(clienteCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCadastro(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteAtualizado = clienteService.atualizar(cliente, id);

        return ResponseEntity.ok(clienteAtualizado);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        Cliente clienteListadoPorId = clienteService.listarPorId(id);

        return ResponseEntity.ok(clienteListadoPorId);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> listarPorNome(@PathVariable String nome) {
        List<Cliente> clienteListadoPorNome = clienteService.listarPorNome(nome);

        return ResponseEntity.ok(clienteListadoPorNome);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos(){
        List<Cliente> listados = clienteService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
