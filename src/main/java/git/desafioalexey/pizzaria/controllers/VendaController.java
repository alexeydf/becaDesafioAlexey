package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.PostVendaRequest;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.GetVendaResponse;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.PostVendaResponse;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<PostVendaResponse> criar(@RequestBody PostVendaRequest venda) {
        PostVendaResponse vendaCriada = vendaService.criar(venda);

        return ResponseEntity.created(null).body(vendaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@RequestBody Venda venda,@PathVariable Long id) {
        Venda vendaAtualizada = vendaService.atualizar(venda, id);

        return ResponseEntity.ok(vendaAtualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetVendaResponse> listarPorId(@PathVariable Long id) {
        GetVendaResponse listadoPorId = vendaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping
    public ResponseEntity<List<GetVendaResponse>> litar() {
        List<GetVendaResponse> listados = vendaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        vendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
