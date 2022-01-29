package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class VendaService implements CrudInterface<Venda>{

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ItemVendaService itemVendaService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public Venda criar(Venda venda) {
        /*Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);

        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        Random gerar = new Random();
        int numeroAleatorio = gerar.nextInt(99);

        venda.setId(Long.valueOf(numeroAleatorio));
        venda.setData(new Date());
        venda.setItens(List.of(
                item, item2
        ));*/

        Cliente cliente = clienteService.listarPorId(venda.getCliente().getId());
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);

        venda.setCliente(cliente);

        List<ItemVenda> itens = itemVendaService.listarTodos();
        venda.setItens(itens);

        cliente.setTotalGasto(cliente.getTotalGasto() + venda.getValorTotal());

        Venda vendaCriada = vendaRepository.save(venda);

        return vendaCriada;
    }

    @Override
    public Venda atualizar(Venda venda, Long id) {
        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);
        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        venda.setItens(List.of(
                item, item2
        ));

        venda.setId(id);

        return venda;
    }

    @Override
    public List<Venda> listarTodos() {
        Cliente cliente1 = new Cliente(1L,"Alexey", "Guara 1", "61 999996666", "a@l.com");
        Cliente cliente2 = new Cliente(2L,"Thanan", "Guara 1", "61 999996669", "t@l.com");

        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);

        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        Venda venda1 = new Venda(2L,new Date(),cliente1);
        Venda venda2 = new Venda(3L, new Date(),cliente2);
        Venda venda3 = new Venda(5L, new Date(),cliente1);

        venda1.setItens(List.of(
                item, item2
        ));
        venda2.setItens(List.of(
                item
        ));
        venda3.setItens(List.of(
                item2
        ));

        List<Venda> vendas = List.of(venda1, venda2, venda3);

        return vendas;
    }

    @Override
    public Venda listarPorId(Long id) {
        Cliente cliente = new Cliente(1L,"Alexey", "Guara 1", "61 999996666", "a@l.com");

        Pizza pizza = new Pizza(1L,"Chocolate", "Doce", 20.0);

        ItemVenda item = new ItemVenda(1L, pizza, 2, 20.0);
        ItemVenda item2 = new ItemVenda(1L, pizza, 5, 20.0);

        Venda venda = new Venda(id, new Date(),cliente);
        venda.setItens(List.of(
                item, item2
        ));

        return venda;
    }

    @Override
    public void excluir(Long id) {
        //
    }
}
