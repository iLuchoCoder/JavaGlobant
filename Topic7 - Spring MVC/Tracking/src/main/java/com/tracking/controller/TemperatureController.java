package com.tracking.controller;

import com.tracking.model.Temperature;
import com.tracking.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    @RequestMapping("/")
    public String homePage(Model model, @Param("keyword") String keyword) {
        List<Temperature> listTemps = service.listAll(keyword);
        model.addAttribute("temperatures", listTemps);
        model.addAttribute("keyword",keyword);
        return "index"; // Return to index.html file
    }

    @RequestMapping("/new_temperature")
    public String registerTemp(Model model){
        Temperature tempo = new Temperature();
        model.addAttribute("temperatures",tempo);
        return "new_temperature";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveTemp(@ModelAttribute("temperatures") Temperature temperature){
        service.save(temperature);
        return "redirect:/";
    }

    @RequestMapping("/edit_temperature/{id}")
    public ModelAndView editTemp(@PathVariable(name = "id") Long id){
        ModelAndView model =  new ModelAndView("edit_temperature");
        Temperature tempo = service.get(id);
        model.addObject("temperatures",tempo);
        return model;
    }

    @RequestMapping("/delete_temperature/{id}")
    public String deleteTemp(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}