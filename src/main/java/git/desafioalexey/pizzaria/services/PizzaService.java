package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PizzaService implements CrudInterface<Pizza> {
    public Pizza criar( Pizza pizza) {
        if(pizza.getSabor().length() < 3 || pizza.getTipo().length() < 3) {
            throw new RuntimeException("Caracteres insuficientes. Informe 3 caracteres ou mais!");
        }

        if(pizza.getPreco() < 0) {
            throw new RuntimeException("Preço informado não é válido!");
        }

        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        pizza.setId(Long.valueOf(numeroAleatorio));

        return pizza;
    }

    public Pizza atualizar(Pizza pizza, Long id) {
        pizza.setId(id);

        return pizza;
    }

    public Pizza listarPorId(Long id) {
        Pizza pizza1 = new Pizza(id,"Calabresa", "Tradicional", 52.69);

        return pizza1;
    }

    public Pizza listarPorSabor(String sabor) {
        Pizza pizza1 = new Pizza(1L,"Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L,"Chocolate", "Doce", 49.69);
        Pizza pizza3 = new Pizza(3L,"Peperoni", "Especial", 63.69);

        List<Pizza> pizzas = List.of(pizza1, pizza2, pizza3);

        for (Pizza pizza: pizzas) {
            if (pizza.getSabor().equalsIgnoreCase(sabor)) {
                Pizza saborPesquisado = pizza;
                return saborPesquisado;
            }
        }

        throw new RuntimeException("Sabor não encontrado. Tente novamente!");
    }

    public List<Pizza> listarTodos() {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L, "Chocolate", "Doce", 49.69);
        Pizza pizza3 = new Pizza(3L, "Peperoni", "Especial", 63.69);

        List<Pizza> pizzas = List.of(pizza1, pizza2, pizza3);

        return pizzas;
    }

    public void excluir(Long id) {
        //
    }
}
