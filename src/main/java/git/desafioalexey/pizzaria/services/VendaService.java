package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService implements CrudInterface<Venda>{

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PizzaService pizzaService;

    @Override
    public Venda criar(Venda venda) {
        Cliente cliente = clienteService.listarPorId(venda.getCliente().getId());
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);
        cliente.setTotalGasto(cliente.getTotalGasto() + venda.getValorTotal());

        venda.setCliente(cliente);
        venda.setData(LocalDate.now());

        for (ItemVenda item: venda.getItens()) {
            Pizza pizza = pizzaService.listarPorId(item.getPizza().getId());

            item.setPizza(pizza);
            item.setPreco(pizza.getPreco());
        }

        return vendaRepository.save(venda);
    }

    @Override
    public Venda atualizar(Venda venda, Long id) {
        Venda vendaEncontrada = this.listarPorId(id);

        vendaEncontrada.setCliente(venda.getCliente());

        vendaRepository.save(vendaEncontrada);

        return venda;
    }

    @Override
    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }

    @Override
    public Venda listarPorId(Long id) {
        return vendaRepository.findById(id).get();
    }

    @Override
    public void excluir(Long id) {
        //
    }
}
