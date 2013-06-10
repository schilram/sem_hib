package ch.zhaw.schilram.sem_hib.web.converter;

import ch.zhaw.schilram.sem_hib.model.UnitOfMeasure;
import ch.zhaw.schilram.sem_hib.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author schilram
 */
@Component
public class StringToUnitOfMeasureConverter implements Converter<String, UnitOfMeasure> {

    @Autowired
    private UnitOfMeasureService service;

    @Override
    public UnitOfMeasure convert(final String id) {
        return service.findOne(Long.parseLong(id));
    }
}
