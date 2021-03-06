package ch.zhaw.schilram.sem_hib.repository;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author schilram
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
