package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.Recipe;
import ch.zhaw.schilram.sem_hib.model.RecipeIngredient;
import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import ch.zhaw.schilram.sem_hib.service.RecipeIngredientService;
import ch.zhaw.schilram.sem_hib.service.RecipeService;
import ch.zhaw.schilram.sem_hib.service.UnitOfMeasureService;
import ch.zhaw.schilram.sem_hib.web.converter.IngredientConverter;
import ch.zhaw.schilram.sem_hib.web.converter.RecipeConverter;
import ch.zhaw.schilram.sem_hib.web.converter.RecipeIngredientConverter;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;
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
import java.util.Collections;
import java.util.List;

/**
 * @author rschilling
 */
@Controller
@RequestMapping("/recipes")
public class RecipeController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeController.class);

    @Autowired
    private RecipeService service;

    @Autowired
    RecipeIngredientService recipeIngredientService;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    UnitOfMeasureService uomService;

    @Resource
    private MessageSource messageSource;


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
     * Shows the add recipe page.
     * @param model The model.
     * @return  The name of the add recipe view.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(final Model model) {

        LOGGER.debug("Showing add ingredient page");

        final List<Ingredient> ingredients = ingredientService.findAll();
        final List<UnitOfMeasure> uom = uomService.findAll();

        // dasdfasfda sdf //
        List<RecipeIngredientDto> rid = new ArrayList<>();
        RecipeIngredientDto d = new RecipeIngredientDto();
        d.setAmount(2);
        d.setUom(uom.get(0));
        d.setIngredient(ingredients.get(0));
        rid.add(d);
        d = new RecipeIngredientDto();
        d.setAmount(4);
        d.setUom(uom.get(1));
        d.setIngredient(ingredients.get(1));
        rid.add(d);
        // asdlfkjalskdfj //

        final RecipeDto formObject = new RecipeDto();
        formObject.setIngredients(rid); //
        model.addAttribute("recipe", formObject);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("uom", uom);

        return "recipes/recipe";
    }

    /**
     * Processes the submit of add Ingredient on recipe form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the recipe view.
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public String addIngredient(final Model model, @Valid @ModelAttribute("recipe") final RecipeDto dto, final BindingResult result, final RedirectAttributes attributes) {

        LOGGER.debug("Adding ingredient to recipe");

        if (result.hasErrors()) {
            LOGGER.debug("Form was submitted with validation errors. Rendering form view.");
            return "recipes/recipe";
        }

        // Persist Recipe
        final Recipe toSave = RecipeConverter.convertForSave(dto);
        final Recipe saved = service.save(toSave);

        // Persist RecipeIngredients
        final Collection<RecipeIngredient> savedRecipeIngredients = new ArrayList<>();
        for (RecipeIngredient recipeIngredient : toSave.getIngredients()) {
            recipeIngredient.setRecipe(saved);
            final RecipeIngredient savedRecipeIngredient = recipeIngredientService.save(recipeIngredient);
            savedRecipeIngredients.add(savedRecipeIngredient);
        }
        // save recipe again with all RecipeIngredients
        saved.setIngredients(savedRecipeIngredients);
        service.save(saved);



        return createRedirectViewPath("/recipes/");
    }


    /**
     * Processes the submit of add Ingredient on recipe form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the recipe view.
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT, params = "addRow")
    public String addRow(final Model model, @Valid @ModelAttribute("recipe") final RecipeDto dto, final BindingResult result, final RedirectAttributes attributes) {

        LOGGER.debug("Adding ingredient to recipe");

        // Persist Recipe
        final Recipe toSave = RecipeConverter.convertForSave(dto);
        final Recipe saved = service.save(toSave);

        // Persist RecipeIngredients
        final Collection<RecipeIngredient> savedRecipeIngredients = new ArrayList<>();
        for (RecipeIngredient recipeIngredient : toSave.getIngredients()) {
            recipeIngredient.setRecipe(saved);
            final RecipeIngredient savedRecipeIngredient = recipeIngredientService.save(recipeIngredient);
            savedRecipeIngredients.add(savedRecipeIngredient);
        }
        // save recipe again with all RecipeIngredients
        saved.setIngredients(savedRecipeIngredients);
        service.save(saved);



        return createRedirectViewPath("/recipes/edit/" + saved.getId());
    }

//    /**
//     * Processes the submit of save recipe form.
//     * @param dto   The form object.
//     * @param result    The binding result describing whether there is validation errors.
//     * @param attributes    The attributes used to when the request is redirected.
//     * @return  A redirect view  name to the recipe view.
//     */
//    @RequestMapping(value = "/save", method = RequestMethod.PUT)
//    public String save(@Valid @ModelAttribute("recipe") final IngredientDto dto, final BindingResult result, final RedirectAttributes attributes) {
//
//        LOGGER.debug("Putting ingredient with information: {}", dto);
//
//        if (result.hasErrors()) {
//            LOGGER.debug("Form was submitted with validation errors. Rendering form view.");
//            return "ingredients/list";
//        }
//
//        final Ingredient toSave = IngredientConverter.convertForSave(dto);
//        final Ingredient saved = service.save(toSave);
//
//        LOGGER.debug("Saved ingredient with information: {}", saved);
//
//        return createRedirectViewPath("/ingredients/");
//    }

    /**
     * Deletes an ingredient and shows the ingredient list view
     * @param id    id of ingredient to delete
     * @return  A redirect view name to the ingredients list view
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        LOGGER.debug("Deleting ingredient with id: {}", id);

        service.deleteById(id);

        return createRedirectViewPath("/ingredients/");
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


        // dasdfasfda sdf //
        List<RecipeIngredientDto> rid = new ArrayList<>();
        RecipeIngredientDto d = new RecipeIngredientDto();
        for (RecipeIngredientDto i : formObject.getIngredients()) {
            d = new RecipeIngredientDto(i.getId(), i.getAmount(), i.getUom(), i.getIngredient());
            rid.add(d);
        }
//        d.setAmount(2);
//        d.setUom(uom.get(0));
//        d.setIngredient(ingredients.get(0));
//        rid.add(d);
//        d = new RecipeIngredientDto();
//        d.setAmount(4);
//        d.setUom(uom.get(1));
//        d.setIngredient(ingredients.get(1));
//        rid.add(d);
        formObject.setIngredients(rid);// asdlfkjalskdfj //

        model.addAttribute("recipe", formObject);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("uom", uom);

        return "recipes/recipe";
    }

}
