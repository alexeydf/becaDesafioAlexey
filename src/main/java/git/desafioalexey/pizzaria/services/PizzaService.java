package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.repositorys.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PizzaService implements CrudInterface<Pizza> {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza criar( Pizza pizza) {
        if(pizza.getSabor().length() < 3 || pizza.getTipo().length() < 3) {
            throw new RuntimeException("Caracteres insuficientes. Informe 3 caracteres ou mais!");
        }

        if(pizza.getPreco() < 0) {
            throw new RuntimeException("Preço informado não é válido!");
        }

        Pizza pizzaCriada =  pizzaRepository.save(pizza);

        return pizzaCriada;
    }

    public Pizza atualizar(Pizza pizza, Long id) {
        Pizza pizzaEncontrada = this.listarPorId(id);

        pizzaEncontrada.setSabor(pizza.getSabor());
        pizzaEncontrada.setTipo(pizza.getTipo());
        pizzaEncontrada.setPreco(pizza.getPreco());

        pizzaRepository.save(pizzaEncontrada);

        return pizzaEncontrada;
    }

    public Pizza listarPorId(Long id) {
        Pizza pizzaLocalizada = pizzaRepository.findById(id).get();

        return pizzaLocalizada;
    }

    public Pizza listarPorSabor(String sabor) {

        List<Pizza> pizzas = pizzaRepository.findAll();

        for (Pizza pizza: pizzas) {
            if (pizza.getSabor().equalsIgnoreCase(sabor)) {
                Pizza saborPesquisado = pizza;
                return saborPesquisado;
            }
        }

        throw new RuntimeException("Sabor não encontrado. Tente novamente!");
    }

    public List<Pizza> listarTodos() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        return pizzas;
    }

    public void excluir(Long id) {
        Pizza pizzaLocalizada = pizzaRepository.findById(id).get();

        pizzaRepository.delete(pizzaLocalizada);
    }
}