package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ItemVendaService implements CrudInterface<ItemVenda> {
    @Override
    public ItemVenda criar(ItemVenda item) {
        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        item.setId(Long.valueOf(numeroAleatorio));

        return item;
    }

    @Override
    public ItemVenda atualizar(ItemVenda item, Long id) {
        item.setId(id);

        return item;
    }

    @Override
    public List<ItemVenda> listarTodos() {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        Pizza pizza2 = new Pizza(2L, "Chocolate", "Doce", 42.69);
        ItemVenda item1 = new ItemVenda(1L, pizza1, 1, pizza1.getPreco());
        ItemVenda item2 = new ItemVenda(2L, pizza2, 1, pizza2.getPreco());
        ItemVenda item3 = new ItemVenda(3L, pizza1, 1, pizza1.getPreco());

        List<ItemVenda> itens = List.of(item1, item2, item3);

        return itens;
    }

    @Override
    public ItemVenda listarPorId(Long id) {
        Pizza pizza1 = new Pizza(1L, "Calabresa", "Tradicional", 52.69);
        ItemVenda item = new ItemVenda(id, pizza1, 1, 52.69);

        return item;
    }

    @Override
    public void excluir(Long id) {
        //
    }
}
