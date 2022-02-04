package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.VendaResponseDTO;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaResponseDTO> criar(@RequestBody @Valid VendaRequestDTO venda) {
        VendaResponseDTO vendaCriada = vendaService.criar(venda);

        return ResponseEntity.created(null).body(vendaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@RequestBody Venda venda,@PathVariable Long id) {
        Venda vendaAtualizada = vendaService.atualizar(venda, id);

        return ResponseEntity.ok(vendaAtualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> listarPorId(@PathVariable Long id) {
        VendaResponseDTO listadoPorId = vendaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> litar() {
        List<VendaResponseDTO> listados = vendaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        vendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
