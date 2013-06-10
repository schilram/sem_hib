package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author schilram
 */
@Entity
@Table(name = "UNIT_OF_MEASURE")
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UnitOfMeasure)) {
            return false;
        }

        final UnitOfMeasure that = (UnitOfMeasure) o;

        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (!key.equals(that.key)) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + key.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
