package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import ch.zhaw.schilram.sem_hib.service.RecipeIngredientService;
import ch.zhaw.schilram.sem_hib.service.RecipeService;
import ch.zhaw.schilram.sem_hib.service.UnitOfMeasureService;
import ch.zhaw.schilram.sem_hib.web.converter.RecipeConverter;
import ch.zhaw.schilram.sem_hib.web.dto.RecipeDto;
import ch.zhaw.schilram.sem_hib.web.dto.RecipeIngredientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author rschilling
 */
@Controller
@RequestMapping("/recipes")
public class RecipeController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    RecipeIngredientService recipeIngredientService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    UnitOfMeasureService uomService;

    @Autowired
    private RecipeService service;

    @Resource
    private MessageSource messageSource;

    /**
     * Shows the add recipe page.
     * @param model The model.
     * @return  The name of the add recipe view.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(final Model model) {
        LOGGER.debug("Showing add recipe page");

        final List<Ingredient> ingredients = ingredientService.findAll();
        final List<UnitOfMeasure> uom = uomService.findAll();

        final List<RecipeIngredientDto> rid = new ArrayList<>();
        final RecipeIngredientDto d = new RecipeIngredientDto();
        rid.add(d);
        rid.add(d);

        final RecipeDto formObject = new RecipeDto();
        formObject.setIngredients(rid);
        model.addAttribute("recipe", formObject);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("uom", uom);

        return "recipes/recipe";
    }

    /**
     * Shows the add recipe page.
     * @param model The model.
     * @return  The name of the add recipe view.
     */
    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String add(final Model model, @PathVariable("id") final Long id) {
        LOGGER.debug("Showing add recipe page with new row");

        final List<Ingredient> ingredients = ingredientService.findAll();
        final List<UnitOfMeasure> uom = uomService.findAll();

        final Recipe toEdit = service.findOne(id);
        final RecipeDto formObject = RecipeConverter.convertToDto(toEdit);
        final Collection<RecipeIngredientDto> dtos = formObject.getIngredients();
        final RecipeIngredientDto dto = new RecipeIngredientDto();
        dtos.add(dto);
        formObject.setIngredients(dtos);

        model.addAttribute("recipe", formObject);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("uom", uom);

        return "recipes/recipe";
    }

    /**
     * Processes the submit of addRow on recipe form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the recipe view.
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT, params = "addRow")
    public String addRow(final Model model, @Valid @ModelAttribute("recipe") final RecipeDto dto, final BindingResult result, final RedirectAttributes attributes) {
        LOGGER.debug("Adding row to recipe");

        final Recipe added = persist(dto);

        return createRedirectViewPath("/recipes/add/" + added.getId());
    }

    private Recipe persist(final RecipeDto dto) {
        final Recipe toSave = RecipeConverter.convertForSave(dto);

        // if it's not a new Recipe delete any removed rows (RecipeIngredients)
        if (dto.getId() != null) {
            final Recipe old = service.findOne(dto.getId());

            // delete removed RecipeIngredients
            for (RecipeIngredient ori : old.getIngredients()) {
                boolean removed = true;
                for (RecipeIngredient nri : toSave.getIngredients()) {
                    if (nri.getId() != null && nri.getId().equals(ori.getId())) {
                        removed = false;
                    }
                }
                if (removed) {
                    recipeIngredientService.delete(ori);
                }
            }
        }

        // save Recipe to get an id
        final Recipe saved = service.save(toSave);

        // Persist RecipeIngredients
        final Collection<RecipeIngredient> savedRecipeIngredients = new ArrayList<>();
        for (RecipeIngredient recipeIngredient : toSave.getIngredients()) {
            if (recipeIngredient.getId() != null || (recipeIngredient.getAmount() != 0 && recipeIngredient.getUom() != null && recipeIngredient.getIngredient() != null)) {
                recipeIngredient.setRecipe(saved);
                final RecipeIngredient savedRecipeIngredient = recipeIngredientService.save(recipeIngredient);
                savedRecipeIngredients.add(savedRecipeIngredient);
            }
        }
        // save recipe again with all RecipeIngredients
        saved.setIngredients(savedRecipeIngredients);

        return service.save(saved);
    }

    /**
     * Deletes a recipe and shows the recipe list view
     * @param id    id of recipe to delete
     * @return  A redirect view name to the recipe list view
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        LOGGER.debug("Deleting ingredient with id: {}", id);

        service.deleteById(id);

        return createRedirectViewPath("/recipes/");
    }

    /**
     * Shows the recipe page.
     * @param model The model.
     * @return  The name of the ingredient view.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        LOGGER.debug("Showing edit ingredient page");

        final List<Ingredient> ingredients = ingredientService.findAll();
        final List<UnitOfMeasure> uom = uomService.findAll();

        final Recipe toEdit = service.findOne(id);
        final RecipeDto formObject = RecipeConverter.convertToDto(toEdit);

        model.addAttribute("recipe", formObject);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("uom", uom);

        return "recipes/recipe";
    }

    /**
     * Shows the recipes page
     * @param model The model
     * @return  The name of the recipes view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(final Model model) {
        LOGGER.debug("Showing recipes list");
        final List<Recipe> recipes = service.findAll();

        model.addAttribute("recipes", recipes);
        return "recipes/list";
    }

    /**
     * Processes the submit of save Recipe form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the recipe view.
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public String save(final Model model, @Valid @ModelAttribute("recipe") final RecipeDto dto, final BindingResult result, final RedirectAttributes attributes) {
        LOGGER.debug("save recipe");

        if (result.hasErrors()) {
            LOGGER.debug("Form was submitted with validation errors. Rendering form view.");
            return "recipes/recipe";
        }
        persist(dto);

        return createRedirectViewPath("/recipes/");
    }

}
