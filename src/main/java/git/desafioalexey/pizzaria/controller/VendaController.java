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

        Random gerar = new Random();
        int nAleatorio = gerar.nextInt(99);

        venda.setId(Long.valueOf(nAleatorio));
        venda.setDataVenda(new Date());
        venda.setQuantidadeTotal(0);
        venda.setValorTotal(0.0);

        return ResponseEntity.created(null).body(venda);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Venda> atualizar(@RequestBody Venda venda,@PathVariable Long id) {

        venda.setId(id);

        return ResponseEntity.ok(venda);
    }

    @GetMapping("/listar/id/{id}")
    public ResponseEntity<Venda> listarPorId(@PathVariable Long id) {
        Cliente cliente = new Cliente(1L,"Alexey", "Guara 1", "61 999996666", "a@l.com");

        Venda venda = new Venda(id, 0, 0.0,new Date(),cliente);

        return ResponseEntity.ok(venda);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Venda>> litar() {
        Cliente cliente1 = new Cliente(1L,"Alexey", "Guara 1", "61 999996666", "a@l.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Guara 1", "61 999996669", "t@l.com");

        Venda venda1 = new Venda(2L, 0, 0.0,new Date(),cliente1);
        Venda venda2 = new Venda(3L, 0, 0.0,new Date(),cliente2);
        Venda venda3 = new Venda(5L, 0, 0.0,new Date(),cliente1);

        List<Venda> vendas = List.of(venda1, venda2, venda3);

        return ResponseEntity.ok(vendas);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
