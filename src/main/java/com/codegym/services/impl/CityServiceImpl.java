package com.codegym.services.impl;

import com.codegym.models.City;
import com.codegym.repositories.CityRepository;
import com.codegym.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }
}
