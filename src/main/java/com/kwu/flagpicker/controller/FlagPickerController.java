package com.kwu.flagpicker.controller;

import com.kwu.flagpicker.exception.ResourceNotFondException;
import com.kwu.flagpicker.model.Continents;
import com.kwu.flagpicker.model.Countries;
import com.kwu.flagpicker.service.FlagPickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flagpicker")
public class FlagPickerController {

    @Autowired
    private FlagPickerService flagPickerService;

    @CrossOrigin
    @GetMapping("/v1/continent")
    public List<Continents> getAllContinents() throws ResourceNotFondException {
        return flagPickerService.getAllContinents();
    }

    @CrossOrigin
    @GetMapping("/v1/countries/{id}")
    public List<Countries> getAllContinents(@PathVariable(value = "id") Long continid) throws ResourceNotFondException {
        return flagPickerService.getAllCountriesByConId(continid);
    }
}
