package ch.zhaw.schilram.sem_hib.service;

import java.io.Serializable;

/**
 * @author rschilling
 */
public interface GenericCrudService<T extends Serializable> extends GenericReadService<T> {

    /**
     * @param persEntity The persistent entity object
     */
    void delete(final T persEntity) throws ObjectInUseException;

    /**
     * @param persEntity The persistent entity object
     */
    <S extends T> S save(final T persEntity);

}
