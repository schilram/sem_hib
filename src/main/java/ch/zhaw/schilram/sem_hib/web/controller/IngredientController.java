package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author rschilling
 */
@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(final Model model) {

        LOGGER.debug("Request for /ingredients/");
        final List<Ingredient> ingredients = service.findAll();

        model.addAttribute("ingredients", ingredients);
        return "ingredients/list";
    }
}
