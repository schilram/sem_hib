package ch.zhaw.schilram.sem_hib.web.converter;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author schilram
 */
@Component
public class StringToIngredientConverter implements Converter<String, Ingredient> {

    @Autowired
    private IngredientService service;

    @Override
    public Ingredient convert(final String id) {
        return service.findOne(Long.parseLong(id));
    }

}
