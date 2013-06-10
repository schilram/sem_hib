package ch.zhaw.schilram.sem_hib.repository;

import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author rschilling
 */
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

}
