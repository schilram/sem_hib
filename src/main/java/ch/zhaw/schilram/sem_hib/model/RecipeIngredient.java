package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author schilram
 */
@Entity
@Table(name = "RECIPEINGREDIENT")
public class RecipeIngredient implements Uniqueness, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer amount;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ingredient ingredient;

    @ManyToOne
    private Recipe recipe;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(final Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(final UnitOfMeasure uom) {
        this.uom = uom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredient)) return false;

        RecipeIngredient that = (RecipeIngredient) o;

        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (!id.equals(that.id)) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null) return false;
        if (recipe != null ? !recipe.equals(that.recipe) : that.recipe != null) return false;
        if (uom != null ? !uom.equals(that.uom) : that.uom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (uom != null ? uom.hashCode() : 0);
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        return result;
    }
}
