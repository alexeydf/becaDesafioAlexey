package git.desafioalexey.pizzaria.controller;

import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/item")
public class ItemVendaController {

    @PostMapping
    public ResponseEntity<ItemVenda> registrar(@RequestBody ItemVenda item){
        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        item.setId(Long.valueOf(numeroAleatorio));

        return ResponseEntity.created(null).body(item);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemVenda> atualizar(@RequestBody ItemVenda item, @PathVariable Long id) {
        item.setId(id);

        return ResponseEntity.ok(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemVenda> listarPorId(@PathVariable Long id) {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        ItemVenda item = new ItemVenda(id, pizza1, 1, 52.69);

        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<ItemVenda>> listar() {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L, "Chocolate", "Doce", 42.69);
        ItemVenda item1 = new ItemVenda(1L, pizza1, 1, pizza1.getPreco());
        ItemVenda item2 = new ItemVenda(2L, pizza2, 1, pizza2.getPreco());
        ItemVenda item3 = new ItemVenda(3L, pizza1, 1, pizza1.getPreco());

        List<ItemVenda> itens = List.of(item1, item2, item3);

        return ResponseEntity.ok(itens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
