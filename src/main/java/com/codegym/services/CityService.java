package com.codegym.services;

import com.codegym.models.City;

public interface CityService {
    Iterable<City> findAll();
    City findById(Long id);
    void save(City city);
    void delete(Long id);
}
