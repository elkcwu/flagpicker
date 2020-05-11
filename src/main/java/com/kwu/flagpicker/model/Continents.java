package com.kwu.flagpicker.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "continents")
public class Continents {

    private Long id;
    @NotBlank(message = "Continent name is mandatory")
    private String continent;

    public Continents(){}
    public Continents(Long id, @NotBlank(message = "Continent name is mandatory") String continent) {
        this.id = id;
        this.continent = continent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
