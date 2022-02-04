package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.mapper.ClienteMapper;
import git.desafioalexey.pizzaria.dtos.mapper.VendaMapper;
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

    @Autowired
    private VendaMapper vendaMapper;

    public VendaResponseDTO criar(VendaRequestDTO vendaRequestDTO) {
        Cliente cliente = clienteRepository.findById(vendaRequestDTO.getClienteId()).get();
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);
        cliente.setTotalGasto(cliente.getTotalGasto() + vendaRequestDTO.getValorTotal());

        Venda vendaCriada = vendaMapper.convertToVenda(vendaRequestDTO);
        vendaCriada.setCliente(cliente);

        vendaRepository.save(vendaCriada);

        VendaResponseDTO vendaResponseDTO = vendaMapper.covertToVendaDTO(vendaCriada);
        vendaResponseDTO.setNomeCliente(cliente.getNome());

        return vendaResponseDTO;
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
            VendaResponseDTO vendaResponseDTO = vendaMapper.covertToVendaDTO(venda);
            vendaResponseDTO.setNomeCliente(venda.getCliente().getNome());

            getVendaResponses.add(vendaResponseDTO);
        }

        return getVendaResponses;
    }

    public VendaResponseDTO listarPorId(Long id) {
        Venda vendaLocalizada = vendaRepository.findById(id).get();

        VendaResponseDTO vendaResponseDTO = vendaMapper.covertToVendaDTO(vendaLocalizada);
        vendaResponseDTO.setNomeCliente(vendaLocalizada.getCliente().getNome());

        return vendaResponseDTO;
    }

    public void excluir(Long id) {
        //
    }
}
