package com.kwu.flagpicker.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "countries")
public class Countries {
    private Long id;
    @NotBlank(message = "Country name is mandatory")
    private String countryname;
    @NotBlank(message = "Country flag name is mandatory")
    private String countryflag;
    private Long continentsId;

    public Countries(){}
    public Countries(Long id, @NotBlank(message = "Country name is mandatory") String countryname, @NotBlank(message = "Country flag name is mandatory") String countryflag){
        this.id = id;
        this.countryname = countryname;
        this.countryflag = countryflag;
    }

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

    public Long getContinentsId() {
        return continentsId;
    }

    public void setContinentsId(Long continentsId) {
        this.continentsId = continentsId;
    }
}
