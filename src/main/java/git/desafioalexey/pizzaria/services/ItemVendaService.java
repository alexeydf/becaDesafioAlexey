package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositorys.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ItemVendaService implements CrudInterface<ItemVenda> {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private VendaService vendaService;

    @Override
    public ItemVenda criar(ItemVenda item) {
        Pizza pizza = pizzaService.listarPorId(item.getPizza().getId());

        item.setPizza(pizza);
        item.setPreco(pizza.getPreco());

        ItemVenda itemVendaCriado = itemVendaRepository.save(item);

        return itemVendaCriado;
    }

    @Override
    public ItemVenda atualizar(ItemVenda item, Long id) {
        ItemVenda itemLocalizado = itemVendaRepository.findById(id).get();

        itemLocalizado.setPizza(item.getPizza());
        itemLocalizado.setQuantidade(item.getQuantidade());

        itemVendaRepository.save(itemLocalizado);

        return itemLocalizado;
    }

    @Override
    public List<ItemVenda> listarTodos() {
        List<ItemVenda> itens = itemVendaRepository.findAll();

        return itens;
    }

    @Override
    public ItemVenda listarPorId(Long id) {
        ItemVenda item = itemVendaRepository.findById(id).get();

        return item;
    }

    @Override
    public void excluir(Long id) {
        ItemVenda itemLocalizado = itemVendaRepository.findById(id).get();

        itemVendaRepository.delete(itemLocalizado);
    }
}
