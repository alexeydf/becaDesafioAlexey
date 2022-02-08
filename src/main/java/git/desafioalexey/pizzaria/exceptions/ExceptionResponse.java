package git.desafioalexey.pizzaria.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private LocalDateTime dataHora;
    private String mensagem;
    private Integer status;
}
