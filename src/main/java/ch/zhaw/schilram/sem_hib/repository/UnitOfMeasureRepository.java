package ch.zhaw.schilram.sem_hib.repository;

import ch.zhaw.schilram.sem_hib.model.Ingredient;
import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author rschilling
 */
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {
}
