package ch.zhaw.schilram.sem_hib.web.converter;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for converting IngredientDto to Ingredient and vice versa.
 *
 * @author schilram
 */
public class IngredientConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientConverter.class);

    public static Ingredient convertForSave(final IngredientDto dto) {

        LOGGER.debug("converting DTO to Ingredient");

        final Ingredient model = new Ingredient();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setFlavour(dto.getFlavour());

        return model;
    }

    public static IngredientDto convertToDto(final Ingredient model) {

        LOGGER.debug("converting Ingredient to DTO");

        final IngredientDto dto = new IngredientDto();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setFlavour(model.getFlavour());

        return dto;
    }
}
