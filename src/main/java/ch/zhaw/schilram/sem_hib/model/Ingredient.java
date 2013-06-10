package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author schilram
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Uniqueness, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Flavour flavour;

    public Ingredient() {

    }

    public Ingredient(final String name, final String description, final Flavour flavour) {
        this.name = name;
        this.description = description;
        this.flavour = flavour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(final Flavour flavour) {
        this.flavour = flavour;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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
        if (!(o instanceof Ingredient)) {
            return false;
        }

        final Ingredient that = (Ingredient) o;

        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (flavour != that.flavour) {
            return false;
        }
        if (!id.equals(that.id)) {
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
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (flavour != null ? flavour.hashCode() : 0);
        return result;
    }
}
