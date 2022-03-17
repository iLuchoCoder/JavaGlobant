package com.meteorological.controller;

import com.meteorological.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    @Autowired
    TemperatureService tempService;

    @GetMapping(value="/")
    public String listTemperatures(Model model){
        model.addAttribute("temperatures",tempService.listAllTemperatures());
        return "index"; // returns the file temperatures
    }
}
