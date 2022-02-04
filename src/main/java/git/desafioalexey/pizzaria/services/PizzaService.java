package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.mapper.PizzaMapper;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PizzaResponseDTO;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PizzaRequestDTO;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaMapper pizzaMapper;

    public PizzaResponseDTO criar(PizzaRequestDTO pizzaRequestDTO) {

        Pizza pizza = pizzaMapper.convertToPizza(pizzaRequestDTO);

        pizzaRepository.save(pizza);

        PizzaResponseDTO pizzaResponseDTO = pizzaMapper.convertToPizzaDTO(pizza);

        return pizzaResponseDTO;
    }

    public PizzaResponseDTO atualizar(PizzaRequestDTO pizzaRequestDTO, Long id) {
        Pizza pizzaEncontrada = pizzaRepository.findById(id).get();

        pizzaRequestDTO.convertToPizza(pizzaRequestDTO,pizzaEncontrada);

        pizzaRepository.save(pizzaEncontrada);

        PizzaResponseDTO pizzaResponseDTO = pizzaMapper.convertToPizzaDTO(pizzaEncontrada);

        return pizzaResponseDTO;
    }

    public PizzaResponseDTO listarPorId(Long id) {
        Pizza pizza = pizzaRepository.findById(id).get();

        PizzaResponseDTO pizzaResponseDTO = pizzaMapper.convertToPizzaDTO(pizza);

        return pizzaResponseDTO;
    }

    public List<PizzaResponseDTO> listarPorSabor(String sabor) {
        List<Pizza> pizzas = pizzaRepository.findBySaborContaining(sabor);

        List<PizzaResponseDTO> pizzaResponseDTOs = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            PizzaResponseDTO pizzaResponseDTO = pizzaMapper.convertToPizzaDTO(pizza);

            pizzaResponseDTOs.add(pizzaResponseDTO);
        }

        return pizzaResponseDTOs;
    }

    public List<PizzaResponseDTO> listarTodos() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        List<PizzaResponseDTO> pizzaResponseDTOs = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            PizzaResponseDTO pizzaResponseDTO = pizzaMapper.convertToPizzaDTO(pizza);

            pizzaResponseDTOs.add(pizzaResponseDTO);
        }

        return pizzaResponseDTOs;
    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }
}
