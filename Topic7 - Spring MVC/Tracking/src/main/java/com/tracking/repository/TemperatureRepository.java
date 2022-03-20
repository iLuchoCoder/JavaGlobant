package com.tracking.repository;

import com.tracking.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

}