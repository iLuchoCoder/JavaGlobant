package com.tracking.controller;

import com.tracking.model.Temperature;
import com.tracking.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @RequestMapping("/")
    public String homePage(Model model) {
        List<Temperature> listTemps = service.listAll();
        model.addAttribute("temperatures", listTemps);
        return "index"; // Return to index.html file
    }

    @RequestMapping("/new")
    public String registerTemp(Model model){
        Temperature tempo = new Temperature();
        model.addAttribute("tempo",tempo);
        return "new_temperature";
    }


}