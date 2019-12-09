package com.codegym.controllers;

import com.codegym.models.City;
import com.codegym.models.Country;
import com.codegym.services.CityService;
import com.codegym.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }
    @GetMapping("/city-list")
    public String cityList(Model model) {
        Iterable<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "cities/list";
    }

    @GetMapping("/city-create")
    public String cityCreate(Model model) {
        model.addAttribute("city", new City());
        return "cities/create";
    }
    @PostMapping("/city-create")
    public String cityCreate(@Validated City city, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("city", city);
            return "cities/create";
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message","Added new city");
        return "redirect:/city-list";
    }

    @GetMapping("/city-edit/{id}")
    public String cityEdit(@PathVariable Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "cities/edit";
    }
    @PostMapping("/city-edit")
    public String cityEdit(@Validated City city,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("city", city);
            return "cities/edit";
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message","Edited city");
        return "redirect:/city-list";
    }
    @GetMapping("/city-delete/{id}")
    public String cityDelete(@PathVariable Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "cities/delete";
    }
    @PostMapping("/city-delete")
    public String cityDelete(City city, Model model, RedirectAttributes redirectAttributes){
        cityService.delete(city.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted city");
        return "redirect:/city-list";
    }
    @GetMapping("/city-view/{id}")
    public String cityView(@PathVariable Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "cities/view";
    }
}

