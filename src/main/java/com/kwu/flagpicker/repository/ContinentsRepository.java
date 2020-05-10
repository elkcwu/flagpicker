package com.kwu.flagpicker.repository;

import com.kwu.flagpicker.model.Continents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentsRepository extends CrudRepository<Continents, Long> {
}
