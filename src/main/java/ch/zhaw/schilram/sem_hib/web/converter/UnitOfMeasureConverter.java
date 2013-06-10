package ch.zhaw.schilram.sem_hib.web.converter;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;
import ch.zhaw.schilram.sem_hib.web.dto.UnitOfMeasureDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for converting UnitOfMeasureDto to UnitOfMeasure and vice versa.
 *
 * @author rschilling
 */
public class UnitOfMeasureConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitOfMeasureConverter.class);

    public static UnitOfMeasure convertForSave(final UnitOfMeasureDto dto) {

        LOGGER.debug("converting Dto to UnitOfMeasure");

        final UnitOfMeasure model = new UnitOfMeasure();

        model.setId(dto.getId());
        model.setKey(dto.getKey());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());

        return model;
    }

    public static UnitOfMeasureDto convertToDto(final UnitOfMeasure model) {

        LOGGER.debug("converting UnitOfMeasure to DTO");

        final UnitOfMeasureDto dto = new UnitOfMeasureDto();

        dto.setId(model.getId());
        dto.setKey(model.getKey());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());

        return dto;
    }
}
