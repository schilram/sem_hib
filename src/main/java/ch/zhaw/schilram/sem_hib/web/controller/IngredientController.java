package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class IngredientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientService service;

    @Resource
    private MessageSource messageSource;

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

        final IngredientDTO formObject = new IngredientDTO();
        model.addAttribute("ingredient", formObject);

        return "ingredients/add";
    }

    /**
     * Processes the submit of add ingredient form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the ingredient view.
     */
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public String addEmployee(@Valid @ModelAttribute("ingredient") final IngredientDTO dto, final BindingResult result, final RedirectAttributes attributes) {

        LOGGER.debug("Adding new ingredient with information: {}", dto);

        if (result.hasErrors()) {
            LOGGER.debug("Form was submitted with validation errors. Rendering form view.");
            return "ingredients/list";
        }

        final Ingredient added = service.add(dto);
        LOGGER.debug("Added ingredient with information: {}", added);

        attributes.addAttribute("id", added.getId());
        addFeedbackMessage(attributes, "ingredient with name={}, description={}, flavour={} added", added.getName(), added.getDescription(), added.getFlavour());

        return createRedirectViewPath("/ingredients/");
    }

    /**
     * Adds a flash feedback message.
     * @param model The model which contains the message.
     * @param code  The code used to fetch the localized message.
     * @param params    The params of the message.
     */
    private void addFeedbackMessage(final RedirectAttributes model, final String code, final Object... params) {
        LOGGER.debug("Adding feedback message with code: {} and params: {}", code, params);
        final String localizedFeedbackMessage = getMessage(code, params);
        LOGGER.debug("Localized message is: {}", localizedFeedbackMessage);
        model.addFlashAttribute("feedbackMessage", localizedFeedbackMessage);
    }

    /**
     * Gets a message from the message source.
     * @param code  The message code.
     * @param params    The params of the message.
     * @return  The localized message.
     */
    private String getMessage(final String code, final Object... params) {
        final Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, params, locale);
    }

    /**
     * Creates a redirect view path.
     * @param requestMapping    The request mapping of target controller method.
     * @return  The created redirect view path.
     */
    private String createRedirectViewPath(final String requestMapping) {
        final StringBuilder redirectViewPath = new StringBuilder();
        redirectViewPath.append("redirect:");
        redirectViewPath.append(requestMapping);
        return redirectViewPath.toString();
    }
}
