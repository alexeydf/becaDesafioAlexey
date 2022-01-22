package git.desafioalexey.pizzaria.controller;

import git.desafioalexey.pizzaria.modelo.Cliente;
import git.desafioalexey.pizzaria.modelo.ItemVenda;
import git.desafioalexey.pizzaria.modelo.Pizza;
import git.desafioalexey.pizzaria.modelo.Venda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemVendaController {

    @PostMapping("/registrar")
    public ResponseEntity<ItemVenda> registrar(@RequestBody ItemVenda item){

        Cliente cliente2 = new Cliente(2L,"Thanan", "Guara 1", "61 999996669", "t@l.com");
        Venda venda1 = new Venda(2L, 0, 0.0,new Date(),cliente2);

        item.setId(15L);
        item.setVenda(venda1);

        venda1.setValorTotal(item.getPreco() * item.getQuantidade());
        venda1.setQuantidadeTotal(item.getQuantidade());

        return ResponseEntity.created(null).body(item);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<ItemVenda> atualizar(@RequestBody ItemVenda item, @PathVariable Long id) {

        item.setId(id);

        return ResponseEntity.ok(item);
    }

    @GetMapping("/listar/id/{id}")
    public ResponseEntity<ItemVenda> listarPorId(@PathVariable Long id) {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        ItemVenda item = new ItemVenda(id, pizza1, 1, 52.69);

        return ResponseEntity.ok(item);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ItemVenda>> listar() {

        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L, "Chocolate", "Doce", 42.69);
        ItemVenda item1 = new ItemVenda(1L, pizza1, 1, pizza1.getPreco());
        ItemVenda item2 = new ItemVenda(2L, pizza2, 1, pizza2.getPreco());
        ItemVenda item3 = new ItemVenda(3L, pizza1, 1, pizza1.getPreco());

        List<ItemVenda> itens = List.of(item1, item2, item3);

        return ResponseEntity.ok(itens);

    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
