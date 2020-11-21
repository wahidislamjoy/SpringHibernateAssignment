package com.springdemo.controller;

import com.springdemo.entity.Country;
import com.springdemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listCountries(Model model)
    {
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries",countries);

        return "country-list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        Country country = new Country();

        model.addAttribute("country",country);

        return "country-form";
    }

    @PostMapping("/saveCountry")

    public String saveCountry(@Valid @ModelAttribute Country country, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "country-form";
        }
        else {
            countryService.saveCountry(country);
            return "redirect:/country/list";
        }

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("countryId") int id,Model model)
    {
        Country country = countryService.getCountryById(id);
        model.addAttribute("country",country);

        return "country-form";
    }


    @GetMapping("/delete")
    public String deleteCountry(@RequestParam("countryId") int id )
    {
       countryService.deleteCountry(id);
        return "redirect:/country/list";
    }
}
