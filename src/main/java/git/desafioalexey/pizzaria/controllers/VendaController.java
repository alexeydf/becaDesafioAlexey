package git.desafioalexey.pizzaria.controllers;

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
    public ResponseEntity<Venda> criar(@RequestBody Venda venda) {
        Venda vendaCriada = vendaService.criar(venda);

        return ResponseEntity.created(null).body(vendaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@RequestBody Venda venda,@PathVariable Long id) {
        Venda vendaAtualizada = vendaService.atualizar(venda, id);

        return ResponseEntity.ok(vendaAtualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> listarPorId(@PathVariable Long id) {
        Venda listadoPorId = vendaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> litar() {
        List<Venda> listados = vendaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        vendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
