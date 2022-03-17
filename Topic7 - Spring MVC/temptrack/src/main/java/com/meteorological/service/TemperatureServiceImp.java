package com.meteorological.service;

import com.meteorological.models.Temperature;
import com.meteorological.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureServiceImp implements TemperatureService{

    @Autowired
    private TemperatureRepository tempRepo;

    @Override
    public List<Temperature> listAllTemperatures() {
        return tempRepo.findAll();
    }
}
