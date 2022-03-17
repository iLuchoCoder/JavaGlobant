package com.meteorological.service;

import com.meteorological.models.Temperature;

import java.util.List;

public interface TemperatureService {

    public List<Temperature> listAllTemperatures();
}
