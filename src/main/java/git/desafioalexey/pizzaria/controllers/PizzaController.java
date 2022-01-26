package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> criarNovo(@RequestBody Pizza pizza) {
       Pizza pizzaCriada = pizzaService.criar(pizza);

        return ResponseEntity.created(null).body(pizzaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pizza> atualizarRegistro(@RequestBody Pizza pizza, @PathVariable Long id) {
        Pizza pizzaAtualizada = pizzaService.atualizar(pizza,id);

        return ResponseEntity.ok(pizzaAtualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> listarRegistroPorId(@PathVariable Long id) {
        Pizza listadoPorId = pizzaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping("/sabor/{sabor}")
    public ResponseEntity<Pizza> listarRegistroPorSabor(@PathVariable String sabor) {
        Pizza listadoPorSabor = pizzaService.listarPorSabor(sabor);

        return ResponseEntity.ok(listadoPorSabor);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> listarResgistros() {
        List<Pizza> listados = pizzaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirRegistro(@PathVariable Long id) {
        pizzaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
