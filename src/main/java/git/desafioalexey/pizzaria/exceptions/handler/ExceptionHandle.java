package git.desafioalexey.pizzaria.exceptions.handler;

import git.desafioalexey.pizzaria.exceptions.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handler(MethodArgumentNotValidException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                LocalDateTime.now(),
                e.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> handler(NoSuchElementException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                LocalDateTime.now(),
                "O ID informado não existe.",
                HttpStatus.NOT_FOUND.value()
        );

        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ExceptionResponse> handler(EmptyResultDataAccessException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                LocalDateTime.now(),
                "O ID informado não existe.",
                HttpStatus.NOT_FOUND.value()
        );

        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handler(DataIntegrityViolationException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                LocalDateTime.now(),
                "Este registro não pode ser excluído.",
                HttpStatus.FORBIDDEN.value()
        );

        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }
}
