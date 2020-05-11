package com.kwu.flagpicker.service;

import com.kwu.flagpicker.model.Continents;
import com.kwu.flagpicker.model.Countries;
import com.kwu.flagpicker.repository.ContinentsRepository;
import com.kwu.flagpicker.repository.CountriesRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableSwagger2
public class FlagPickerService {

    @Autowired
    private ContinentsRepository continentsRepository;
    @Autowired
    private CountriesRepository countriesRepository;

    @Cacheable("flagPicker")
    @HystrixCommand(fallbackMethod = "getFallbackAllContinents")
    public List<Continents> getAllContinents(){
        List<Continents> continentList = new ArrayList<>();
        continentsRepository.findAll()
                .forEach(continentList :: add);
        return continentList;
    }

    @HystrixCommand
    public List<Continents> getFallbackAllContinents(){
        List<Continents> continentList = new ArrayList<>();
        Continents continent = new Continents(000L, "Not a valid continent");
        continentList.add(continent);
        return continentList;
    }

    @Cacheable("flagPicker")
    @HystrixCommand(fallbackMethod = "getFallbackAllCountriesByConId")
    public List<Countries> getAllCountriesByConId(Long continentid){
        List<Countries> countriesList = new ArrayList<>();
        countriesRepository.findByContinentsId(continentid)
                .forEach(countriesList :: add);
        return countriesList;
    }

    @HystrixCommand
    public List<Countries> getFallbackAllCountriesByConId(Long continentsid){
        List<Countries> countriesList = new ArrayList<>();
        Countries coun = new Countries();
        coun.setCountryname("Not real continent name");
        coun.setCountryflag("00");
        coun.setId(000L);
        countriesList.add(coun);
        return countriesList;
    }
}
