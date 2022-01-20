package git.desafioalexey.pizzaria.modelo;

import java.util.Date;

public class Cliente {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Integer comprasRealizadas;
    private Double totalGasto;
    private Date dataCadastro;

    public Cliente() {
    }

    public Cliente(String nome, String endereco, String telefone, String email, Date dataCadastro) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
