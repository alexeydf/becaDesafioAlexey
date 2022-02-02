package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.PostVendaRequest;
import git.desafioalexey.pizzaria.dtos.responses.clienteResponses.GetClienteResponse;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.GetVendaResponse;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.PostVendaResponse;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.ItemVenda;
import git.desafioalexey.pizzaria.models.Pizza;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import git.desafioalexey.pizzaria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ClienteRepository clienteRepository;

    public PostVendaResponse criar(PostVendaRequest postVendaRequest) {
        Cliente cliente = clienteRepository.findById(postVendaRequest.getClienteId()).get();
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);
        cliente.setTotalGasto(cliente.getTotalGasto() + postVendaRequest.getValorTotal());

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setItens(postVendaRequest.getItens());

        Venda vendaCriada = vendaRepository.save(venda);

        PostVendaResponse postVendaResponse = new PostVendaResponse();
        postVendaResponse.setItens(vendaCriada.getItens());
        postVendaResponse.setNomeCliente(vendaCriada.getCliente().getNome());
        postVendaResponse.setValorTotal(vendaCriada.getValorTotal());

        return postVendaResponse;
    }

    public Venda atualizar(Venda venda, Long id) {
        Venda vendaEncontrada = vendaRepository.findById(id).get();

        vendaEncontrada.setCliente(venda.getCliente());

        vendaRepository.save(vendaEncontrada);

        return venda;
    }

    public List<GetVendaResponse> listarTodos() {
        List<Venda> vendas = vendaRepository.findAll();

        List<GetVendaResponse> getVendaResponses = new ArrayList<>();

        for (Venda venda: vendas) {
            GetVendaResponse getVendaResponse = new GetVendaResponse();

            getVendaResponse.setItens(venda.getItens());
            getVendaResponse.setNomeCliente(venda.getCliente().getNome());
            getVendaResponse.setValorTotal(venda.getValorTotal());

            getVendaResponses.add(getVendaResponse);
        }

        return getVendaResponses;
    }

    public GetVendaResponse listarPorId(Long id) {
        Venda vendaLocalizada = vendaRepository.findById(id).get();

        GetVendaResponse getVendaResponse = new GetVendaResponse();
        getVendaResponse.setItens(vendaLocalizada.getItens());
        getVendaResponse.setNomeCliente(vendaLocalizada.getCliente().getNome());
        getVendaResponse.setValorTotal(vendaLocalizada.getValorTotal());

        return getVendaResponse;
    }

    public void excluir(Long id) {
        //
    }
}
