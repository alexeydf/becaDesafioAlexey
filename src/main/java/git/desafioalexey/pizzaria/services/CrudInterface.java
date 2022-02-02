package git.desafioalexey.pizzaria.services;

import java.util.List;

public interface CrudInterface<Object> {
    Object criar(Object objeto);
    Object atualizar(Object objeto, Long id);
    List<Object> listarTodos();
    Object listarPorId(Long id);
    void excluir(Long id);
}
