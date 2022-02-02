package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.PachClienteRequest;
import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.PostClienteRequest;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.PatchClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.PostClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PostPizzaResponse;
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
    public ResponseEntity<PostClienteResponse> cadastrar(@RequestBody PostClienteRequest cliente) {
       PostClienteResponse clienteCriado = clienteService.criar(cliente);

        return ResponseEntity.created(null).body(clienteCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchClienteResponse> atualizarCadastro(@RequestBody PachClienteRequest cliente, @PathVariable Long id) {
        PatchClienteResponse clienteAtualizado = clienteService.atualizar(cliente, id);

        return ResponseEntity.ok(clienteAtualizado);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClienteResponse> listarPorId(@PathVariable Long id) {
        GetClienteResponse clienteListadoPorId = clienteService.listarPorId(id);

        return ResponseEntity.ok(clienteListadoPorId);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Cliente>> listarPorNome(@PathVariable String nome) {
        List<Cliente> clienteListadoPorNome = clienteService.listarPorNome(nome);

        return ResponseEntity.ok(clienteListadoPorNome);
    }

    @GetMapping
    public ResponseEntity<List<GetClienteResponse>> listarTodos(){
        List<GetClienteResponse> listados = clienteService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
