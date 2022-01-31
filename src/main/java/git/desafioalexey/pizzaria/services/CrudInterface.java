package git.desafioalexey.pizzaria.services;

import java.util.List;

public interface CrudInterface<T> {
    T criar(T objeto);
    T atualizar(T objeto, Long id);
    List<T> listarTodos();
    T listarPorId(Long id);
    void excluir(Long id);
}
