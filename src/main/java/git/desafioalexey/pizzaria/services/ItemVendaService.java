package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.repositories.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
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
        return itemVendaRepository.findAll();
    }

    @Override
    public ItemVenda listarPorId(Long id) {
        return itemVendaRepository.findById(id).get();
    }

    @Override
    public void excluir(Long id) {
        itemVendaRepository.deleteById(id);
    }
}
