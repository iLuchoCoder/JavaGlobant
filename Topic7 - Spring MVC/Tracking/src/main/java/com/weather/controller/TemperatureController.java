package com.weather.controller;

import com.weather.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @GetMapping({"/","/temperature"})
    public String listTemperatures(Model model){
        model.addAttribute("temperatures",service.listAll());
        return "index"; // Return to index.html file on templates
    }

}
