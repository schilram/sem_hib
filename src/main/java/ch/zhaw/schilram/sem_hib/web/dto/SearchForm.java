package ch.zhaw.schilram.sem_hib.web.dto;

import ch.zhaw.schilram.sem_hib.model.Ingredient;

/**
 * @author rschilling
 */
public class SearchForm {

    private Ingredient ingredient1;

    private Ingredient ingredient2;

    private Ingredient ingredient3;

    public Ingredient getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(final Ingredient ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public Ingredient getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(final Ingredient ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public Ingredient getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(final Ingredient ingredient3) {
        this.ingredient3 = ingredient3;
    }
}
