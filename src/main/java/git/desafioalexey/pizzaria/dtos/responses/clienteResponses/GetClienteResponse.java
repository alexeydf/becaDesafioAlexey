package git.desafioalexey.pizzaria.dtos.responses.clienteResponses;

import java.time.LocalDate;

public class GetClienteResponse {
    private Long codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Integer comprasRealizadas;
    private Double totalGasto;
    private LocalDate dataCadastro;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(Integer comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    public Double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(Double totalGasto) {
        this.totalGasto = totalGasto;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}