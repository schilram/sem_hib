package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rschilling
 */
@Entity
@Table(name = "FLAVOUR")
public enum Flavour implements Uniqueness, Serializable {

    SALTY(1L), SWEET(2L), SOUR(3L), BITTER(4L), UMAMI(5L);

    @Id
    private Long id;

    private Flavour(final Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

}
