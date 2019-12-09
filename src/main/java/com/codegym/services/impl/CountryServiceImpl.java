package com.codegym.services.impl;

import com.codegym.models.Country;
import com.codegym.repositories.CountryRepository;
import com.codegym.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(id);
    }
}
