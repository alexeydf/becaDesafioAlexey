package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.GetPizzaResponse;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PatchPizzaResponse;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PostPizzaResponse;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PatchPizzaRequest;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PostPizzaRequest;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<PostPizzaResponse> criarNovo(@RequestBody PostPizzaRequest postPizzaRequest) {
       PostPizzaResponse pizzaCriada = pizzaService.criar(postPizzaRequest);

        return ResponseEntity.created(null).body(pizzaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatchPizzaResponse> atualizarRegistro(@RequestBody PatchPizzaRequest pizza, @PathVariable Long id) {
        PatchPizzaResponse pizzaAtualizada = pizzaService.atualizar(pizza,id);

        return ResponseEntity.ok(pizzaAtualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPizzaResponse> listarRegistroPorId(@PathVariable Long id) {
        GetPizzaResponse listadoPorId = pizzaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping("/sabor/{sabor}")
    public ResponseEntity<Pizza> listarRegistroPorSabor(@PathVariable String sabor) {
        Pizza listadoPorSabor = pizzaService.listarPorSabor(sabor);

        return ResponseEntity.ok(listadoPorSabor);
    }

    @GetMapping
    public ResponseEntity<List<GetPizzaResponse>> listarResgistros() {
        List<GetPizzaResponse> listados = pizzaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirRegistro(@PathVariable Long id) {
        pizzaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
