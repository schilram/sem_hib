package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.repository.RecipeIngredientRepository;
import ch.zhaw.schilram.sem_hib.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rschilling
 */
@Service
public class RecipeIngredientServiceImpl extends AbstractCrudService<RecipeIngredient, Long> implements RecipeIngredientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeIngredientServiceImpl.class);

    @Autowired
    private RecipeIngredientRepository repository;

    @Override
    RecipeIngredientRepository getRepository() {
        return repository;
    }

}
