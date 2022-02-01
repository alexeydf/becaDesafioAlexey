package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class VendaService implements CrudInterface<Venda>{

    @Autowired
    private VendaRepository vendaRepository;

    /*@Autowired
    private ItemVendaService itemVendaService;*/

    @Autowired
    private ClienteService clienteService;

    @Override
    public Venda criar(Venda venda) {
        Cliente cliente = clienteService.listarPorId(venda.getCliente().getId());
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);

        venda.setCliente(cliente);
        venda.setData(LocalDate.now());

        List<ItemVenda> itens = venda.getItens();
        venda.setItens(itens);

        cliente.setTotalGasto(cliente.getTotalGasto() + venda.getValorTotal());

        Venda vendaCriada = vendaRepository.save(venda);

        return vendaCriada;
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
        List<Venda> vendas = vendaRepository.findAll();

        return vendas;
    }

    @Override
    public Venda listarPorId(Long id) {
        Venda venda = vendaRepository.findById(id).get();

        return venda;
    }

    @Override
    public void excluir(Long id) {
        //
    }
}
