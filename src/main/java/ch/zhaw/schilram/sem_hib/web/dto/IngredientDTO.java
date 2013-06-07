package ch.zhaw.schilram.sem_hib.web.dto;

import ch.zhaw.schilram.sem_hib.model.Flavour;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author rschilling
 */
public class IngredientDto {

    private Long id;

    @NotEmpty
    private String name;

    private String description;

    private Flavour flavour;

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
}
