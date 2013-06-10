package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author schilram
 */
@Entity
@Table(name = "RECIPE")
public class Recipe implements Uniqueness, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    private Collection<RecipeIngredient> ingredients;

    private String instructions;

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

    public Collection<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(final Collection<RecipeIngredient> ingredients) {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Recipe)) {
            return false;
        }

        final Recipe recipe = (Recipe) o;

        if (description != null ? !description.equals(recipe.description) : recipe.description != null) {
            return false;
        }
        if (!id.equals(recipe.id)) {
            return false;
        }
        if (ingredients != null ? !ingredients.equals(recipe.ingredients) : recipe.ingredients != null) {
            return false;
        }
        if (instructions != null ? !instructions.equals(recipe.instructions) : recipe.instructions != null) {
            return false;
        }
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (instructions != null ? instructions.hashCode() : 0);
        return result;
    }

}
