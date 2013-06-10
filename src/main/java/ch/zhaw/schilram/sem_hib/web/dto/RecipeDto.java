package ch.zhaw.schilram.sem_hib.web.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author schilram
 */
public class RecipeDto {

    private Long id;

    @NotEmpty
    private String name;

    private String description;

    private Collection<RecipeIngredientDto> ingredients;

    private String instructions;

//    private RecipeIngredientDto ingredientDto;

    public RecipeDto() {
        ingredients = new ArrayList<>();
    }

    public RecipeDto(final Long id, final String name, final String description, final Collection<RecipeIngredientDto> ingredients, final String instructions) {
        this.id = id;
        this.name = name;
        this.description = description;
        if (ingredients != null) {
            this.ingredients = ingredients;
        } else {
            this.ingredients = new ArrayList<>();
        }
        this.instructions = instructions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Collection<RecipeIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(final Collection<RecipeIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(final String instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

//    public RecipeIngredientDto getIngredientDto() {
//        return ingredientDto;
//    }
//
//    public void setIngredientDto(final RecipeIngredientDto ingredientDto) {
//        this.ingredientDto = ingredientDto;
//    }
}
