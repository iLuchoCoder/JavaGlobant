package com.tracking.service;

import com.tracking.model.Temperature;
import com.tracking.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepository repo;

    public List<Temperature> listAll(String keyword){
        if(keyword != null){
            return repo.findAll(keyword);
        }
        return repo.findAll();
    }

    public void save(Temperature tempo) {
        repo.save(tempo);
    }

    public Temperature get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}