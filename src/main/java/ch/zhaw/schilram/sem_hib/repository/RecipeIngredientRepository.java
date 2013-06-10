package ch.zhaw.schilram.sem_hib.repository;

import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.Query;


/**
 * @author rschilling
 */
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

}
