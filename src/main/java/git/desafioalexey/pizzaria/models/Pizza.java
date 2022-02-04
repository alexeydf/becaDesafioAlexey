package git.desafioalexey.pizzaria.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 3, max = 30, message = "{min.caracter}")
    private String sabor;

    @NotBlank(message = "{campo.not.blank}")
    @Size(min = 3, max = 30, message = "{min.caracter}")
    private String tipo;

    @NotNull(message = "{campo.not.blank}")
    @Min(value = 0, message = "{preco.min.valor}")
    private Double preco;
}
