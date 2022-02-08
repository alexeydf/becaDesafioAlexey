package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.mapper.PizzaMapper;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PizzaResponseDTO;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PizzaRequestDTO;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.repositories.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class  PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    public PizzaResponseDTO criar(PizzaRequestDTO pizzaRequestDTO) {
        Pizza pizza = pizzaMapper.toPizza(pizzaRequestDTO);

        pizzaRepository.save(pizza);

        return pizzaMapper.toPizzaDTO(pizza);
    }

    public PizzaResponseDTO atualizar(PizzaRequestDTO pizzaRequestDTO, Long id) {
        Pizza pizzaEncontrada = pizzaRepository.findById(id).get();

        pizzaMapper.atualizar(pizzaRequestDTO, pizzaEncontrada);

        pizzaRepository.save(pizzaEncontrada);

        return pizzaMapper.toPizzaDTO(pizzaEncontrada);
    }

    public PizzaResponseDTO listarPorId(Long id) {
        Pizza pizza = pizzaRepository.findById(id).get();

        return pizzaMapper.toPizzaDTO(pizza);
    }

    public List<PizzaResponseDTO> listarPorSabor(String sabor) {
        List<Pizza> pizzas = pizzaRepository.findBySaborContaining(sabor);

        List<PizzaResponseDTO> pizzaResponseDTOs = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            pizzaResponseDTOs.add(pizzaMapper.toPizzaDTO(pizza));
        }

        return pizzaResponseDTOs;
    }

    public List<PizzaResponseDTO> listarTodos() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        List<PizzaResponseDTO> pizzaResponseDTOs = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            pizzaResponseDTOs.add(pizzaMapper.toPizzaDTO(pizza));
        }

        return pizzaResponseDTOs;
    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }
}
