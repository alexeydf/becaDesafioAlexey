package git.desafioalexey.pizzaria.repositories;

import git.desafioalexey.pizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findBySaborContaining(String sabor);
}
