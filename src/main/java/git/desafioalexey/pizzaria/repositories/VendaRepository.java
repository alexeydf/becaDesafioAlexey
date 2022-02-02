package git.desafioalexey.pizzaria.repositories;

import git.desafioalexey.pizzaria.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
