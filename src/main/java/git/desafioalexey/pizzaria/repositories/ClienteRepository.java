package git.desafioalexey.pizzaria.repositories;

import git.desafioalexey.pizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContains(String nome);
}
