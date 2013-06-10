package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Recipe;

/**
 * @author schilram
 */
public interface RecipeService extends CrudService<Recipe, Long> {

    void deleteById(Long id);
}
