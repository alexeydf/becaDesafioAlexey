package git.desafioalexey.pizzaria.controller;

import git.desafioalexey.pizzaria.models.Pizza;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @PostMapping
    public ResponseEntity<Pizza> criarNovo(@RequestBody Pizza pizza) {
        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        pizza.setId(Long.valueOf(numeroAleatorio));

        if(pizza.getPreco() < 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.created(null).body(pizza);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pizza> atualizarRegistro(@RequestBody Pizza pizza, @PathVariable Long id) {
        pizza.setId(id);

        return ResponseEntity.ok(pizza);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> listarRegistroPorId(@PathVariable Long id) {
        Pizza pizza1 = new Pizza(id,"Calabresa", "Tradicional", 52.69);

        return ResponseEntity.ok(pizza1);
    }

    @GetMapping("/sabor/{sabor}")
    public ResponseEntity<Pizza> listarRegistroPorSabor(@PathVariable String sabor) {
        Pizza pizza1 = new Pizza(1L,"Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L,"Chocolate", "Doce", 49.69);
        Pizza pizza3 = new Pizza(3L,"Peperoni", "Especial", 63.69);

        List<Pizza> pizzas = List.of(pizza1, pizza2, pizza3);

        for (Pizza pizza: pizzas) {
            if (pizza.getSabor().equalsIgnoreCase(sabor)) {
                Pizza saborPesquisado = pizza;
                return ResponseEntity.ok(saborPesquisado);
            }
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> listarResgistros() {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L, "Chocolate", "Doce", 49.69);
        Pizza pizza3 = new Pizza(3L, "Peperoni", "Especial", 63.69);

        List<Pizza> pizzas = List.of(pizza1, pizza2, pizza3);

        return ResponseEntity.ok(pizzas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirRegistro(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
