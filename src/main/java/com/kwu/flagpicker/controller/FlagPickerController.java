package com.kwu.flagpicker.controller;

import com.kwu.flagpicker.exception.ResourceNotFondException;
import com.kwu.flagpicker.model.Continents;
import com.kwu.flagpicker.model.Countries;
import com.kwu.flagpicker.service.FlagPickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flagpicker/")
public class FlagPickerController {

    @Autowired
    FlagPickerService flagPickerService;

    @GetMapping("v1/continent")
    public List<Continents> getAllContinents() throws ResourceNotFondException {
        return flagPickerService.getAllContinents();
    }

    @GetMapping("v1/countries/{id}")
    public List<Countries> getAllContinents(@PathVariable(value = "id") Long continentId) throws ResourceNotFondException {
        return flagPickerService.getAllCountriesByConId(continentId);
    }
}
