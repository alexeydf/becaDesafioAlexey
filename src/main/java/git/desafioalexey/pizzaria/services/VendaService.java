package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.mapper.ClienteMapper;
import git.desafioalexey.pizzaria.dtos.mapper.VendaMapper;
import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.VendaResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import git.desafioalexey.pizzaria.repositories.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {
    private final VendaRepository vendaRepository;
    private final ClienteService clienteService;
    private final PizzaService pizzaService;
    private final ClienteRepository clienteRepository;
    private final VendaMapper vendaMapper;

    public VendaResponseDTO criar(VendaRequestDTO vendaRequestDTO) {
        Cliente cliente = clienteRepository.findById(vendaRequestDTO.getClienteId()).get();
        cliente.setComprasRealizadas(cliente.getComprasRealizadas() + 1);
        cliente.setTotalGasto(cliente.getTotalGasto() + vendaRequestDTO.getValorTotal());

        Venda vendaCriada = vendaMapper.convertToVenda(vendaRequestDTO);
        vendaCriada.setCliente(cliente);

        vendaRepository.save(vendaCriada);

        VendaResponseDTO vendaResponseDTO = vendaMapper.covertToVendaDTO(vendaCriada);
        vendaResponseDTO.setClienteNome(cliente.getNome());

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
            vendaResponseDTO.setClienteNome(venda.getCliente().getNome());

            getVendaResponses.add(vendaResponseDTO);
        }

        return getVendaResponses;
    }

    public VendaResponseDTO listarPorId(Long id) {
        Venda vendaLocalizada = vendaRepository.findById(id).get();

        VendaResponseDTO vendaResponseDTO = vendaMapper.covertToVendaDTO(vendaLocalizada);
        vendaResponseDTO.setClienteNome(vendaLocalizada.getCliente().getNome());

        return vendaResponseDTO;
    }

    public void excluir(Long id) {
        //
    }
}
