package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return pizzaRepository.save(pizza);
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
        return pizzaRepository.findById(id).get();
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
        return pizzaRepository.findAll();
    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }
}
