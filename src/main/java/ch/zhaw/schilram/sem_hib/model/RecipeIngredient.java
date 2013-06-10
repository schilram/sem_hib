package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rschilling
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

}
