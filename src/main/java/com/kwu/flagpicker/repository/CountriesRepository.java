package com.kwu.flagpicker.repository;

import com.kwu.flagpicker.model.Countries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends CrudRepository<Countries, Long> {
    public List<Countries> findByContinentId(Long continentId);
}
