package git.alexeydf.pizzaria.modelo;

import java.time.LocalDate;

public class CompraFinalizada {

    private Long id;
    private Integer quantidadeComprada;
    private Double valorTotalPago;
    private LocalDate dataVenda = LocalDate.now();
    private Long idCliente;

    public CompraFinalizada() {
    }

    public CompraFinalizada(Integer quantidadeComprada, Double valorTotalPago, LocalDate dataVenda, Long idCliente) {
        this.quantidadeComprada = quantidadeComprada;
        this.valorTotalPago = valorTotalPago;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
    }
}
