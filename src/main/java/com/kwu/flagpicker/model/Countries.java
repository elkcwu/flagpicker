package com.kwu.flagpicker.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Countries {
    private Long id;
    @NotBlank(message = "Country name is mandatory")
    private String countryname;
    @NotBlank(message = "Country flag name is mandatory")
    private String countryflag;
    private Continents continent;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryflag() {
        return countryflag;
    }

    public void setCountryflag(String countryflag) {
        this.countryflag = countryflag;
    }

    @ManyToOne(targetEntity = Continents.class)
    public Continents getContinent() {
        return continent;
    }

    public void setContinent(Continents continent) {
        this.continent = continent;
    }

}
