package ch.zhaw.schilram.sem_hib.repository;

import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author schilram
 */
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

}
