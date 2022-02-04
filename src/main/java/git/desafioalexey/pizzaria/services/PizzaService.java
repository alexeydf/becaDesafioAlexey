package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PizzaResponseDTO;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PizzaRequestDTO;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaResponseDTO criar(PizzaRequestDTO pizzaRequestDTO) {
        if(pizzaRequestDTO.getSabor().length() < 3 || pizzaRequestDTO.getTipo().length() < 3) {
            throw new RuntimeException("Caracteres insuficientes. Informe 3 caracteres ou mais!");
        }

        if(pizzaRequestDTO.getPreco() < 0) {
            throw new RuntimeException("Preço informado não é válido!");
        }

        Pizza pizza = new Pizza();
        pizzaRequestDTO.convertToPizza(pizzaRequestDTO,pizza);

        pizzaRepository.save(pizza);

        return new PizzaResponseDTO().covertToPizzaDTO(pizza);
    }

    public PizzaResponseDTO atualizar(PizzaRequestDTO pizzaRequestDTO, Long id) {
        Pizza pizzaEncontrada = pizzaRepository.findById(id).get();

        pizzaRequestDTO.convertToPizza(pizzaRequestDTO,pizzaEncontrada);

        pizzaRepository.save(pizzaEncontrada);

        return new PizzaResponseDTO().covertToPizzaDTO(pizzaEncontrada);
    }

    public PizzaResponseDTO listarPorId(Long id) {
        Pizza pizza = pizzaRepository.findById(id).get();

        return new PizzaResponseDTO().covertToPizzaDTO(pizza);
    }

    public List<PizzaResponseDTO> listarPorSabor(String sabor) {
        List<Pizza> pizzas = pizzaRepository.findBySaborContaining(sabor);

        List<PizzaResponseDTO> pizzaResponseDTOs = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            pizzaResponseDTOs.add(new PizzaResponseDTO().covertToPizzaDTO(pizza));
        }

        return pizzaResponseDTOs;
    }

    public List<PizzaResponseDTO> listarTodos() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        List<PizzaResponseDTO> pizzaResponseDTOs = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            pizzaResponseDTOs.add(new PizzaResponseDTO().covertToPizzaDTO(pizza));
        }

        return pizzaResponseDTOs;
    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }
}
