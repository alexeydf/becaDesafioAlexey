package git.desafioalexey.pizzaria.services;

import git.desafioalexey.pizzaria.dtos.mapper.VendaMapper;
import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaAtualizarDTO;
import git.desafioalexey.pizzaria.dtos.requests.vendaRequests.VendaRequestDTO;
import git.desafioalexey.pizzaria.dtos.responses.vendaResponses.VendaResponseDTO;
import git.desafioalexey.pizzaria.models.Cliente;
import git.desafioalexey.pizzaria.models.Venda;
import git.desafioalexey.pizzaria.repositories.ClienteRepository;
import git.desafioalexey.pizzaria.repositories.VendaRepository;
import lombok.RequiredArgsConstructor;
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

        Venda vendaCriada = vendaMapper.toVenda(vendaRequestDTO);
        vendaCriada.setCliente(cliente);

        vendaRepository.save(vendaCriada);

        VendaResponseDTO vendaResponseDTO = vendaMapper.toVendaDTO(vendaCriada);
        vendaResponseDTO.setClienteNome(cliente.getNome());

        return vendaResponseDTO;
    }

    public VendaResponseDTO atualizar(VendaAtualizarDTO vendaAtualizarDTO, Long id) {
        Venda vendaEncontrada = vendaRepository.findById(id).get();

        Cliente cliente = clienteRepository.findById(vendaEncontrada.getCliente().getId()).get();
        cliente.setTotalGasto((cliente.getTotalGasto() - vendaEncontrada.getValorTotal()) + vendaAtualizarDTO.getValorTotal());

        vendaMapper.atualizar(vendaAtualizarDTO, vendaEncontrada);

        vendaRepository.save(vendaEncontrada);

        return vendaMapper.toVendaDTO(vendaEncontrada);
    }

    public List<VendaResponseDTO> listarTodos() {
        List<Venda> vendas = vendaRepository.findAll();

        List<VendaResponseDTO> getVendaResponses = new ArrayList<>();

        for (Venda venda: vendas) {
            VendaResponseDTO vendaResponseDTO = vendaMapper.toVendaDTO(venda);
            vendaResponseDTO.setClienteNome(venda.getCliente().getNome());

            getVendaResponses.add(vendaResponseDTO);
        }

        return getVendaResponses;
    }

    public VendaResponseDTO listarPorId(Long id) {
        Venda vendaLocalizada = vendaRepository.findById(id).get();

        VendaResponseDTO vendaResponseDTO = vendaMapper.toVendaDTO(vendaLocalizada);
        vendaResponseDTO.setClienteNome(vendaLocalizada.getCliente().getNome());

        return vendaResponseDTO;
    }

    public void excluir(Long id) {
        //
    }
}
