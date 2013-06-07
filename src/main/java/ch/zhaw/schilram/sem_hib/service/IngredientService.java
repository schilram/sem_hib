package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.web.dto.IngredientDto;

import java.util.List;

/**
 * @author rschilling
 */
public interface IngredientService extends GenericCrudService<Ingredient> {

//    /**
//     * Adds a new ingredient.
//     * @param added The information of the added ingredient.
//     * @return  The added ingredient.
//     */
//    Ingredient add(IngredientDto added);

    /**
     * Deletes an ingredient.
     * @param id    The id of the deleted ingredient.
     * @return  The deleted ingredient.
     * @throws NotFoundException    if a ingredient is not found with the given id.
     */
    Ingredient deleteById(Long id) throws NotFoundException;

//    /**
//     * Finds all ingredients.
//     * @return  A list of ingredients. If no ingredient is found this method returns an empty list.
//     */
//    List<Ingredient> findAll();

//    /**
//     * Finds an ingredient.
//     * @param id    The id of the wanted ingredient.
//     * @return  The found ingredient.
//     * @throws NotFoundException    if no ingredient is found with the given id.
//     */
//    Ingredient findById(Long id) throws NotFoundException;

//    /**
//     * Updates the information of a ingredient.
//     * @param updated   The new information of a ingredient.
//     * @return  The updated ingredient.
//     * @throws NotFoundException    if no ingredient is found with the provided id.
//     */
//    Ingredient update(Ingredient updated);

}
