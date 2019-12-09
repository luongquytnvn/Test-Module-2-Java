package com.codegym.services;

import com.codegym.models.Country;

public interface CountryService {
    Iterable<Country> findAll();
    Country findById(Long id);
    void save(Country country);
    void delete(Long id);
}
