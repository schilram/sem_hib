package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import org.springframework.data.jpa.repository.Query;

/**
 * @author rschilling
 */
public interface RecipeIngredientService extends CrudService<RecipeIngredient, Long> {

}
