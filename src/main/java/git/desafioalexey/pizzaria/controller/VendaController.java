package git.desafioalexey.pizzaria.controller;

import git.desafioalexey.pizzaria.modelo.Cliente;
import git.desafioalexey.pizzaria.modelo.ItemVenda;
import git.desafioalexey.pizzaria.modelo.Pizza;
import git.desafioalexey.pizzaria.modelo.Venda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @PostMapping("/criar")
    public ResponseEntity<Venda> criar(@RequestBody Venda venda) {

        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);
        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);
        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        venda.setId(Long.valueOf(numeroAleatorio));
        venda.setData(new Date());
        venda.setItens(List.of(
            item, item2
        ));

        return ResponseEntity.created(null).body(venda);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Venda> atualizar(@RequestBody Venda venda,@PathVariable Long id) {

        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);
        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        venda.setItens(List.of(
                item, item2
        ));

        venda.setId(id);

        return ResponseEntity.ok(venda);
    }

    @GetMapping("/listar/id/{id}")
    public ResponseEntity<Venda> listarPorId(@PathVariable Long id) {
        Cliente cliente = new Cliente(1L,"Alexey", "Guara 1", "61 999996666", "a@l.com");


        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);
        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        Venda venda = new Venda(id, new Date(),cliente);
        venda.setItens(List.of(
                item, item2
        ));

        return ResponseEntity.ok(venda);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Venda>> litar() {
        Cliente cliente1 = new Cliente(1L,"Alexey", "Guara 1", "61 999996666", "a@l.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Guara 1", "61 999996669", "t@l.com");

        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);
        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        Venda venda1 = new Venda(2L,new Date(),cliente1);
        Venda venda2 = new Venda(3L, new Date(),cliente2);
        Venda venda3 = new Venda(5L, new Date(),cliente1);


        venda1.setItens(List.of(
                item, item2
        ));
        venda2.setItens(List.of(
                item
        ));
        venda3.setItens(List.of(
                item2
        ));


        List<Venda> vendas = List.of(venda1, venda2, venda3);

        return ResponseEntity.ok(vendas);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
