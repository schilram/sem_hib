package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author schilram
 */
@Service
public class IngredientServiceImpl extends AbstractCrudService<Ingredient, Long> implements IngredientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientServiceImpl.class);

    @Autowired
    private IngredientRepository repository;

    @Override
    IngredientRepository getRepository() {
        return repository;
    }

}
