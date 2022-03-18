package com.weather.service;

import com.weather.model.Temperature;
import com.weather.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureServiceImp implements TemperatureService{

    @Autowired
    private TemperatureRepository repo;

    @Override
    public List<Temperature> listAll() {
        return repo.findAll();
    }
}
