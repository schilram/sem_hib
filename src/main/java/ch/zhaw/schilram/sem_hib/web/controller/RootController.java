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
@RequestMapping("/")
public class RootController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    /**
     * Shows the the index page
     * @param model The model
     * @return  The name of the index view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(final Model model) {

        LOGGER.debug("Showing index page");

        return "index";
    }

}
