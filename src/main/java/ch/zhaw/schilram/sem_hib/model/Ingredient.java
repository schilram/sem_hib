package ch.zhaw.schilram.sem_hib.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rschilling
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Uniqueness, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

//    @ManyToOne(optional = true, fetch = FetchType.EAGER)
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

}
