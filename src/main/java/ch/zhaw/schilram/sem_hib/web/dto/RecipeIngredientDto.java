package ch.zhaw.schilram.sem_hib.web.dto;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author schilram
 */
public class RecipeIngredientDto {

    private Long id;

    private int amount;

    private UnitOfMeasure uom;

    private Ingredient ingredient;

    public RecipeIngredientDto() {

    }

    public RecipeIngredientDto(final Long id, final int amount, final UnitOfMeasure uom, final Ingredient ingredient) {
        this.id = id;
        this.amount = amount;
        this.uom = uom;
        this.ingredient = ingredient;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(final Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(final UnitOfMeasure uom) {
        this.uom = uom;
    }

}
