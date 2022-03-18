package com.meteorological.controller;

import com.meteorological.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @GetMapping({"/","/temperature"})
    public String showAll(Model model){
        model.addAttribute("temperatures", service.listAllTemperatures());
        return "index"; // returns to index.html file
    }
}
