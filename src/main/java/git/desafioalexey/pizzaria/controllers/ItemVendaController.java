package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.services.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/item")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PatchMapping("/{id}")
    public ResponseEntity<ItemVenda> atualizar(@RequestBody ItemVenda item, @PathVariable Long id) {
        ItemVenda itemVendaAtualizado = itemVendaService.atualizar(item, id);

        return ResponseEntity.ok(itemVendaAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemVenda> listarPorId(@PathVariable Long id) {
        ItemVenda listadoPorId = itemVendaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping
    public ResponseEntity<List<ItemVenda>> listar() {
        List<ItemVenda> listados = itemVendaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        itemVendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
