package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.dtos.requests.clienteRequests.ClienteRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.ClienteResponseDTO;
import git.desafioalexey.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(@RequestBody @Valid ClienteRequestDTO cliente) {
       ClienteResponseDTO clienteCriado = clienteService.criar(cliente);

        return ResponseEntity.created(null).body(clienteCriado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCadastro(@RequestBody @Valid ClienteRequestDTO cliente, @PathVariable Long id) {
        ClienteResponseDTO clienteAtualizado = clienteService.atualizar(cliente, id);

        return ResponseEntity.ok(clienteAtualizado);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClienteResponse> listarPorId(@PathVariable Long id) {
        GetClienteResponse clienteListadoPorId = clienteService.listarPorId(id);

        return ResponseEntity.ok(clienteListadoPorId);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<GetClienteResponse>> listarPorNome(@PathVariable String nome) {
        List<GetClienteResponse> clienteListadoPorNome = clienteService.listarPorNome(nome);

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
