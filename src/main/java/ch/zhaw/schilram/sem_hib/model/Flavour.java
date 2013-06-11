package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author schilram
 */
@Entity
@Table(name = "FLAVOUR")
public enum Flavour implements Uniqueness, Serializable {

    SALZIG(1L), SUESS(2L), SAUER(3L), BITTER(4L), UMAMI(5L);

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
