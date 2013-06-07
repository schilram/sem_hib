package ch.zhaw.schilram.sem_hib.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author rschilling
 */
public interface ReadService<T , ID extends Serializable> {

    /**
     * @return Number of T object entities
     */
    long count();


    boolean exists(ID id);

    /**
     * @return A list of {@link T} objects (if any); otherwise return <code>null</code>
     */
    List<T> findAll();

    /**
     * @param id The id of the entity to retrieve
     *
     * @return The T object (if any); otherwise return <code>null</code>
     */
    T findOne(ID id);

}
