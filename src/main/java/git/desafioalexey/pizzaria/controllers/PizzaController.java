package git.desafioalexey.pizzaria.controllers;

import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PizzaResponseDTO;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PizzaRequestDTO;
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
    public ResponseEntity<PizzaResponseDTO> criarNovo(@RequestBody PizzaRequestDTO pizzaRequestDTO) {
       PizzaResponseDTO pizzaCriada = pizzaService.criar(pizzaRequestDTO);

        return ResponseEntity.created(null).body(pizzaCriada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PizzaResponseDTO> atualizarRegistro(@RequestBody PizzaRequestDTO pizza, @PathVariable Long id) {
        PizzaResponseDTO pizzaAtualizada = pizzaService.atualizar(pizza,id);

        return ResponseEntity.ok(pizzaAtualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaResponseDTO> listarRegistroPorId(@PathVariable Long id) {
        PizzaResponseDTO listadoPorId = pizzaService.listarPorId(id);

        return ResponseEntity.ok(listadoPorId);
    }

    @GetMapping("/sabor/{sabor}")
    public ResponseEntity<List<PizzaResponseDTO>> listarRegistroPorSabor(@PathVariable String sabor) {
        List<PizzaResponseDTO> listadoPorSabor = pizzaService.listarPorSabor(sabor);

        return ResponseEntity.ok(listadoPorSabor);
    }

    @GetMapping
    public ResponseEntity<List<PizzaResponseDTO>> listarResgistros() {
        List<PizzaResponseDTO> listados = pizzaService.listarTodos();

        return ResponseEntity.ok(listados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirRegistro(@PathVariable Long id) {
        pizzaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
