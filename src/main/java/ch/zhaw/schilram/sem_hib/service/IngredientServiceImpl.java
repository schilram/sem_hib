package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.repository.IngredientRepository;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author rschilling
 */
@Service
public class IngredientServiceImpl implements IngredientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientServiceImpl.class);

    @Autowired
    private IngredientRepository repository;

    @Transactional
    @Override
    public Ingredient add(final IngredientDTO added) {
        LOGGER.debug("Adding new ingredient with information: {}", added);

        final Ingredient ingredient = new Ingredient(added.getName(), added.getDescription(), added.getFlavour());

        save(ingredient);
        LOGGER.debug("Added new ingredient with information: {}", ingredient);

        return ingredient;
    }

    @Transactional
    @Override
    public Ingredient save(final Ingredient persEntity) {
        LOGGER.debug("Updating ingredient with information {}", persEntity);
        return repository.save(persEntity);
    }

    @Override
    public long count() {
        LOGGER.debug("Count ingredients");
        return repository.count();
    }

    @Transactional(rollbackFor = ObjectInUseException.class)
    @Override
    public void delete(final Ingredient persEntity) throws ObjectInUseException {
        LOGGER.debug("Deleting ingredient with information: {}", persEntity);
        repository.delete(persEntity);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    @Override
    public Ingredient deleteById(final Long id) throws NotFoundException {
        LOGGER.debug("Finding ingredient by id: {}", id);

        final Ingredient found = repository.findOne(id);

        if (found == null) {
            LOGGER.debug("No ingredient found by id: {}", id);
            throw new NotFoundException();
        }
        LOGGER.debug("Found ingredient: {}", found);
        return found;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Ingredient> findAll() {
        LOGGER.debug("Finding all ingredients");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Ingredient findOne(final Long id) {
        LOGGER.debug("Finding ingredient by id: {}", id);
        return repository.findOne(id);
    }

    @Transactional(rollbackFor = NotFoundException.class)
    @Override
    public Ingredient update(final Ingredient updated) {
        LOGGER.debug("Updating ingredient with information {}", updated);
        repository.save(updated);
        return updated;
    }

}
