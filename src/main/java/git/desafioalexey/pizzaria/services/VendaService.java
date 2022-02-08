package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.VendaResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import git.desafioalexey.pizzaria.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public VendaResponseDTO criar(VendaRequestDTO vendaRequestDTO) {
        Cliente cliente = clienteRepository.findById(vendaRequestDTO.getClienteId()).get();
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);
        cliente.setTotalGasto(cliente.getTotalGasto() + vendaRequestDTO.getValorTotal());

        Venda vendaCriada = vendaRepository.save(vendaRequestDTO.convertToVenda(cliente, vendaRequestDTO));

        return new VendaResponseDTO().convertToVendaDTO(vendaCriada);
    }

    public Venda atualizar(Venda venda, Long id) {
        Venda vendaEncontrada = vendaRepository.findById(id).get();

        vendaEncontrada.setCliente(venda.getCliente());

        vendaRepository.save(vendaEncontrada);

        return venda;
    }

    public List<VendaResponseDTO> listarTodos() {
        List<Venda> vendas = vendaRepository.findAll();

        List<VendaResponseDTO> getVendaResponses = new ArrayList<>();

        for (Venda venda: vendas) {
            getVendaResponses.add(new VendaResponseDTO().convertToVendaDTO(venda));
        }

        return getVendaResponses;
    }

    public VendaResponseDTO listarPorId(Long id) {
        Venda vendaLocalizada = vendaRepository.findById(id).get();

        return new VendaResponseDTO().convertToVendaDTO(vendaLocalizada);
    }

    public void excluir(Long id) {
        //
    }
}
