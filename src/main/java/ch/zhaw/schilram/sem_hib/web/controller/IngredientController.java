package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import ch.zhaw.schilram.sem_hib.web.converter.IngredientConverter;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @author rschilling
 */
@Controller
@RequestMapping("/ingredients")
public class IngredientController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientService service;

    @Resource
    private MessageSource messageSource;

    /**
     * Shows the ingredients page
     * @param model The model
     * @return  The name of the ingredients view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(final Model model) {

        LOGGER.debug("Showing ingredients list");
        final List<Ingredient> ingredients = service.findAll();

        model.addAttribute("ingredients", ingredients);
        return "ingredients/list";
    }

    /**
     * Shows the add ingredient page.
     * @param model The model.
     * @return  The name of the add ingredient view.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(final Model model) {

        LOGGER.debug("Showing add ingredient page");

        final IngredientDto formObject = new IngredientDto();
        model.addAttribute("ingredient", formObject);

        return "ingredients/ingredient";
    }

    /**
     * Processes the submit of save ingredient form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the ingredient view.
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public String save(@Valid @ModelAttribute("ingredient") final IngredientDto dto, final BindingResult result, final RedirectAttributes attributes) {

        LOGGER.debug("Putting ingredient with information: {}", dto);

        if (result.hasErrors()) {
            LOGGER.debug("Form was submitted with validation errors. Rendering form view.");
            return "ingredients/list";
        }

        final Ingredient toSave = IngredientConverter.convertForSave(dto);
        final Ingredient saved = service.save(toSave);

        LOGGER.debug("Saved ingredient with information: {}", saved);

        return createRedirectViewPath("/ingredients/");
    }

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
     * Shows the ingredient page.
     * @param model The model.
     * @return  The name of the ingredient view.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {

        LOGGER.debug("Showing edit ingredient page");

        final Ingredient toEdit = service.findOne(id);
        final IngredientDto formObject = IngredientConverter.convertToDto(toEdit);
        model.addAttribute("ingredient", formObject);

        return "ingredients/ingredient";
    }

}
