package git.desafioalexey.pizzaria.repositories;

import git.desafioalexey.pizzaria.models.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
}
