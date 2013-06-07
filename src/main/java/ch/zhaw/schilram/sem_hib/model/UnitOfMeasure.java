package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rschilling
 */
@Entity
@Table(name = "INGREDIENT")
public class UnitOfMeasure implements Uniqueness, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String key;

    private String name;

    private String description;

    public UnitOfMeasure() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
