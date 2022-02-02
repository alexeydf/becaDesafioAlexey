package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.GetPizzaResponse;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PatchPizzaResponse;
import git.desafioalexey.pizzaria.dtos.responses.pizzaResponses.PostPizzaResponse;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PatchPizzaRequest;
import git.desafioalexey.pizzaria.dtos.requests.pizzaRequests.PostPizzaRequest;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.GetVendaResponse;
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

    public PostPizzaResponse criar(PostPizzaRequest postPizzaRequest) {
        if(postPizzaRequest.getSabor().length() < 3 || postPizzaRequest.getTipo().length() < 3) {
            throw new RuntimeException("Caracteres insuficientes. Informe 3 caracteres ou mais!");
        }

        if(postPizzaRequest.getPreco() < 0) {
            throw new RuntimeException("Preço informado não é válido!");
        }

        Pizza pizza = new Pizza();
        pizza.setSabor(postPizzaRequest.getSabor());
        pizza.setTipo(postPizzaRequest.getTipo());
        pizza.setPreco(postPizzaRequest.getPreco());

        Pizza pizzaCriada = pizzaRepository.save(pizza);

        PostPizzaResponse postPizzaResponse = new PostPizzaResponse();
        postPizzaResponse.setCodigo(pizzaCriada.getId());
        postPizzaResponse.setSabor(pizzaCriada.getSabor());
        postPizzaResponse.setTipo(pizzaCriada.getTipo());
        postPizzaResponse.setPreco(pizzaCriada.getPreco());
        postPizzaResponse.setMensagem("Pizza criada com sucesso.");

        return postPizzaResponse;
    }

    public PatchPizzaResponse atualizar(PatchPizzaRequest pizzaRequest, Long id) {
        Pizza pizzaEncontrada = pizzaRepository.findById(id).get();

        pizzaEncontrada.setSabor(pizzaRequest.getSabor());
        pizzaEncontrada.setTipo(pizzaRequest.getTipo());
        pizzaEncontrada.setPreco(pizzaRequest.getPreco());

        pizzaRepository.save(pizzaEncontrada);

        PatchPizzaResponse pizzaResponse = new PatchPizzaResponse();
        pizzaResponse.setCodigo(pizzaEncontrada.getId());
        pizzaResponse.setSabor(pizzaEncontrada.getSabor());
        pizzaResponse.setTipo(pizzaEncontrada.getTipo());
        pizzaResponse.setPreco(pizzaEncontrada.getPreco());
        pizzaResponse.setMensagem("Registro atualizado com sucesso.");

        return pizzaResponse;
    }

    public GetPizzaResponse listarPorId(Long id) {
        Pizza pizza = pizzaRepository.findById(id).get();

        GetPizzaResponse getPizzaResponse = new GetPizzaResponse();
        getPizzaResponse.setCodigo(pizza.getId());
        getPizzaResponse.setTipo(pizza.getTipo());
        getPizzaResponse.setSabor(pizza.getSabor());
        getPizzaResponse.setPreco(pizza.getPreco());

        return getPizzaResponse;
    }

    public List<GetPizzaResponse> listarPorSabor(String sabor) {
        List<Pizza> pizzas = pizzaRepository.findBySaborContaining(sabor);

        List<GetPizzaResponse> getPizzaResponses = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            GetPizzaResponse getPizzaResponse = new GetPizzaResponse();

            getPizzaResponse.setCodigo(pizza.getId());
            getPizzaResponse.setSabor(pizza.getSabor());
            getPizzaResponse.setTipo(pizza.getTipo());
            getPizzaResponse.setPreco(pizza.getPreco());

            getPizzaResponses.add(getPizzaResponse);
        }

        return getPizzaResponses;
    }

    public List<GetPizzaResponse> listarTodos() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        List<GetPizzaResponse> getPizzaResponses = new ArrayList<>();

        for (Pizza pizza: pizzas) {
            GetPizzaResponse getPizzaResponse = new GetPizzaResponse();

            getPizzaResponse.setCodigo(pizza.getId());
            getPizzaResponse.setSabor(pizza.getSabor());
            getPizzaResponse.setTipo(pizza.getTipo());
            getPizzaResponse.setPreco(pizza.getPreco());

            getPizzaResponses.add(getPizzaResponse);
        }

        return getPizzaResponses;
    }

    public void excluir(Long id) {
        pizzaRepository.deleteById(id);
    }
}
