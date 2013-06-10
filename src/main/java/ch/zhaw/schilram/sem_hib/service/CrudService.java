package ch.zhaw.schilram.sem_hib.service;

import java.io.Serializable;

/**
 * @author schilram
 */
public interface CrudService<T, ID extends Serializable> extends ReadService<T, ID> {

    void delete(final T persEntity);

    void deleteAll();

    void deleteById(ID id);

    T save(final T persEntity);

}
