package ch.zhaw.schilram.sem_hib.web.converter;

import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.web.dto.RecipeDto;
import ch.zhaw.schilram.sem_hib.web.dto.RecipeIngredientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for converting RecipeDto to Recipe and vice versa.
 *
 * @author rschilling
 */
public class RecipeConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeConverter.class);

    public static Recipe convertForSave(final RecipeDto dto) {

        LOGGER.debug("converting DTO to Recipe");

        final Recipe model = new Recipe();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setIngredients(RecipeIngredientConverter.convertCollectionForSave(dto.getIngredients()));
        model.setInstructions(dto.getInstructions());

        return model;
    }

    public static RecipeDto convertToDto(final Recipe model) {

        LOGGER.debug("converting Recipe to DTO");

        final RecipeDto dto = new RecipeDto();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setIngredients(RecipeIngredientConverter.convertCollectionToDto(model.getIngredients()));
        dto.setInstructions(model.getInstructions());

        return dto;
    }
}
