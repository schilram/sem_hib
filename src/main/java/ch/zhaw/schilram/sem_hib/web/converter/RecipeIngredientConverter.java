package ch.zhaw.schilram.sem_hib.web.converter;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;
import ch.zhaw.schilram.sem_hib.web.dto.RecipeIngredientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin2.main.server.ResultID;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Class for converting RecipeIngredientDto to RecipeIngredient and vice versa.
 *
 * @author rschilling
 */
public class RecipeIngredientConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeIngredientConverter.class);

    public static RecipeIngredient convertForSave(final RecipeIngredientDto dto) {

        LOGGER.debug("converting DTO to RecipeIngredient");

        final RecipeIngredient model = new RecipeIngredient();

        model.setId(dto.getId());
        model.setIngredient(dto.getIngredient());
        model.setUom(dto.getUom());
        model.setAmount(dto.getAmount());

        return model;
    }

    public static RecipeIngredientDto convertToDto(final RecipeIngredient model) {

        LOGGER.debug("converting RecipeIngredient to DTO");

        final RecipeIngredientDto dto = new RecipeIngredientDto();

        dto.setId(model.getId());
        dto.setIngredient(model.getIngredient());
        dto.setUom(model.getUom());
        dto.setAmount(model.getAmount());

        return dto;
    }

    public static Collection<RecipeIngredient> convertCollectionForSave(final Collection<RecipeIngredientDto> dtos) {
        final Collection<RecipeIngredient> modelCollection = new ArrayList<>();
        for (RecipeIngredientDto dto : dtos) {
            RecipeIngredient model = convertForSave(dto);
            modelCollection.add(model);
        }

        return modelCollection;
    }

    public static Collection<RecipeIngredientDto> convertCollectionToDto(final Collection<RecipeIngredient> models) {
        final Collection<RecipeIngredientDto> dtoCollection = new ArrayList<>();
        for (RecipeIngredient model : models) {
            RecipeIngredientDto dto = convertToDto(model);
            dtoCollection.add(dto);
        }

        return dtoCollection;
    }
}