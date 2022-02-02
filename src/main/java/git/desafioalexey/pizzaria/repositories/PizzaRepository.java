package git.desafioalexey.pizzaria.repositories;

import git.desafioalexey.pizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
