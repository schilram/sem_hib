package ch.zhaw.schilram.sem_hib.web.controller;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import ch.zhaw.schilram.sem_hib.service.IngredientService;
import ch.zhaw.schilram.sem_hib.service.UnitOfMeasureService;
import ch.zhaw.schilram.sem_hib.web.converter.IngredientConverter;
import ch.zhaw.schilram.sem_hib.web.converter.UnitOfMeasureConverter;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;
import ch.zhaw.schilram.sem_hib.web.dto.UnitOfMeasureDto;
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
import java.util.List;

/**
 * @author schilram
 */
@Controller
@RequestMapping("/uom")
public class UnitOfMeasureController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitOfMeasureController.class);

    @Autowired
    private UnitOfMeasureService service;

    @Resource
    private MessageSource messageSource;

    /**
     * Shows the unit of measure page
     * @param model The model
     * @return  The name of the unit of measure view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(final Model model) {

        LOGGER.debug("Showing unit of measure list");
        final List<UnitOfMeasure> unitsOfMeasure = service.findAll();

        model.addAttribute("unitsOfMeasure", unitsOfMeasure);
        return "uom/list";
    }

    /**
     * Shows the add unit of measure page.
     * @param model The model.
     * @return  The name of the add unit of measure view.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(final Model model) {

        LOGGER.debug("Showing add unit of measure page");

        final UnitOfMeasureDto formObject = new UnitOfMeasureDto();
        model.addAttribute("unitOfMeasure", formObject);

        return "uom/unitOfMeasure";
    }

    /**
     * Processes the submit of save unit of measure form.
     * @param dto   The form object.
     * @param result    The binding result describing whether there is validation errors.
     * @param attributes    The attributes used to when the request is redirected.
     * @return  A redirect view  name to the unit of measure view.
     */
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public String save(@Valid @ModelAttribute("unitOfMeasure") final UnitOfMeasureDto dto, final BindingResult result, final RedirectAttributes attributes) {

        LOGGER.debug("Putting unit of measure with information: {}", dto);

        if (result.hasErrors()) {
            LOGGER.debug("Form was submitted with validation errors. Rendering form view.");
            return "uom/list";
        }

        final UnitOfMeasure toSave = UnitOfMeasureConverter.convertForSave(dto);
        final UnitOfMeasure saved = service.save(toSave);

        LOGGER.debug("Saved ingredient with information: {}", saved);

        return createRedirectViewPath("/uom/");
    }

    /**
     * Deletes a unit of measure and shows the unit of measure list view
     * @param id    id of unit of measure to delete
     * @return  A redirect view name to the unit of measure list view
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        LOGGER.debug("Deleting unit of measure with id: {}", id);

        service.deleteById(id);

        return createRedirectViewPath("/uom/");
    }

    /**
     * Shows the unit of measure page.
     * @param model The model.
     * @return  The name of the unit of measure view.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {

        LOGGER.debug("Showing edit unit of measure page");

        final UnitOfMeasure toEdit = service.findOne(id);
        final UnitOfMeasureDto formObject = UnitOfMeasureConverter.convertToDto(toEdit);
        model.addAttribute("unitOfMeasure", formObject);

        return "uom/unitOfMeasure";
    }

}
