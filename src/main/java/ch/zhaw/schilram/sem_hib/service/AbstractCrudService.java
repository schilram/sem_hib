package ch.zhaw.schilram.sem_hib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author schilram
 */
public abstract class AbstractCrudService<T, ID extends Serializable> implements CrudService<T, ID> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudService.class);

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void delete(final T persEntity) {
        getRepository().delete(persEntity);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public void deleteById(final ID id) {
        getRepository().delete(id);
    }

    @Override
    public boolean exists(final ID id) {
        return getRepository().exists(id);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findOne(final ID id) {
        return getRepository().findOne(id);
    }

    abstract <R extends JpaRepository<T, ID>> R getRepository();

    @Override
    public T save(final T persEntity) {
        return getRepository().save(persEntity);
    }

}
