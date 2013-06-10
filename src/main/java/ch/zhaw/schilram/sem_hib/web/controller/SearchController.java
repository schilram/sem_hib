package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import ch.zhaw.schilram.sem_hib.service.RecipeService;
import ch.zhaw.schilram.sem_hib.web.dto.SearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author schilram
 */
@Controller
@RequestMapping("/search")
public class SearchController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;


    /**
     * Shows the the search page
     * @param model The model
     * @return  The name of the search view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(final Model model) {

        LOGGER.debug("Showing search page");

        final List<Ingredient> ingredients = ingredientService.findAll();
        final SearchForm searchForm = new SearchForm();

//        Ingredient i = new Ingredient();
//        List<Ingredient> searchList = new ArrayList<>();
//        searchList.add(i);
//        searchList.add(i);
//        searchList.add(i);
//        searchForm.setIngredients(searchList);

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("ingredients", ingredients);

        return "search/search";
    }


    /**
     * Shows the results for the search
     * @param model The model
     * @return  The name of the result view
     */
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String list(final Model model, @ModelAttribute("searchForm") final SearchForm form, final BindingResult result, final RedirectAttributes attributes) {

        LOGGER.debug("Showing filtered Recipe list");

        final List<Recipe> recipes = recipeService.findAll();

        final List<Recipe> list1hit = new ArrayList<>();
        final List<Recipe> list2hit = new ArrayList<>();
        final List<Recipe> list3hit = new ArrayList<>();

        for (Recipe recipe : recipes) {
            int score = 0;
            final Collection<RecipeIngredient> recipeIngredients = recipe.getIngredients();
            for (RecipeIngredient recipeIngredient: recipeIngredients) {
                final Ingredient ingredient = recipeIngredient.getIngredient();
                if (ingredient.equals(form.getIngredient1())
                    || ingredient.equals(form.getIngredient2())
                    || ingredient.equals(form.getIngredient3())) {
                    score++;
                }
            }

            switch (score) {
                case 1:
                    list1hit.add(recipe);
                    break;
                case 2:
                    list2hit.add(recipe);
                    break;
                case 3:
                    list3hit.add(recipe);
                    break;
                default:
            }
        }

        model.addAttribute("list1hit", list1hit);
        model.addAttribute("list2hit", list2hit);
        model.addAttribute("list3hit", list3hit);
        return "search/result";
    }


}
