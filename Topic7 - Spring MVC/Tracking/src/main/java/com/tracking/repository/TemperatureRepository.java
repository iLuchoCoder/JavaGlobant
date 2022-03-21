package com.tracking.repository;

import com.tracking.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

    @Query("SELECT t FROM Temperature t WHERE CONCAT(t.id,t.city,t.country,t.latitude,t.longitude,t.state,t.temperature) LIKE %?1%")
    public List<Temperature> findAll(String keyword);

}