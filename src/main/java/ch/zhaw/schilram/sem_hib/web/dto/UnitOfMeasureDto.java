package ch.zhaw.schilram.sem_hib.web.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author schilram
 */
public class UnitOfMeasureDto {

    private Long id;

    @NotEmpty
    private String key;

    private String name;

    private String description;

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
