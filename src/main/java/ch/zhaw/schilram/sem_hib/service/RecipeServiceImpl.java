package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author schilram
 */
@Service
public class RecipeServiceImpl extends AbstractCrudService<Recipe, Long> implements RecipeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeServiceImpl.class);

    @Autowired
    private RecipeRepository repository;

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @Override
    public RecipeRepository getRepository() {
        return repository;
    }

    @Override
    public void deleteById(final Long id) {
        final Recipe toDelete = findOne(id);
        
        for (RecipeIngredient ri : toDelete.getIngredients()) {
            recipeIngredientService.delete(ri);
        }

        repository.delete(id);
    }

}
