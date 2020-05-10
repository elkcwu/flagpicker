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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableSwagger2
@Transactional
public class FlagPickerService {

    @Autowired
    ContinentsRepository continentsRepository;
    CountriesRepository countriesRepository;

    @Cacheable("flagPicker")
    @HystrixCommand(fallbackMethod = "getFallbackAllContinents")
    public List<Continents> getAllContinents(){
        List<Continents> continentList = new ArrayList<>();
        continentsRepository.findAll()
                .forEach(continentList :: add);
        return continentList;
    }

    public String getFallbackAllContinents(){
        return "Cannot get Continents list";
    }

    @Cacheable("flagPicker")
    @HystrixCommand(fallbackMethod = "getFallbackAllCountriesByConId")
    public List<Countries> getAllCountriesByConId(Long continentid){
        List<Countries> countriesList = new ArrayList<>();
        countriesRepository.findByContinentId(continentid)
                .forEach(countriesList :: add);
        return countriesList;
    }

    public String getFallbackAllCountriesByConId(Long continentid){
        return "Cannot get Countries list";
    }

}
