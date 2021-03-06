package ch.zhaw.schilram.sem_hib.service;

import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import ch.zhaw.schilram.sem_hib.repository.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author schilram
 */
@Service
public class UnitOfMeasureServiceImpl extends AbstractCrudService<UnitOfMeasure, Long> implements UnitOfMeasureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitOfMeasureServiceImpl.class);

    @Autowired
    private UnitOfMeasureRepository repository;

    @Override
    UnitOfMeasureRepository getRepository() {
        return repository;
    }

}
