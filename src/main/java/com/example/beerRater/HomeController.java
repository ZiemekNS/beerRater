package com.example.beerRater;

import com.example.beerRater.domain.Property;
import com.example.beerRater.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyService propertyService;

    private final String title = "Baza piw";

    public List<Property> findByKeyword(String keyword) {
        return propertyRepository.findByKeyword(keyword);
    }


    @GetMapping("/")
    public String index(Model model, String keyword) {

        model.addAttribute("title", title);
        model.addAttribute("properties", propertyRepository.findAll());

        if (keyword != null) {
            model.addAttribute("properties", propertyRepository.findByKeyword(keyword));
        } else {
            model.addAttribute("title", title);
            model.addAttribute("properties", propertyRepository.findAll());
        }
        return "index";
    }

    @GetMapping("/submit")
    public String rateBeerForm(Model model) {
        model.addAttribute("properties", new Property());
        return "submit_form";
    }

    @GetMapping("/property/change/{id}")
    public String singlePropertyView(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("properties", propertyRepository.findById(id).get());
        return "property/change";
    }

    @PostMapping("/property_submit")
    public String propertySubmit(Property property) {
        if (propertyService.checkTheDates(property).containsValue("submit_success")) {
            propertyRepository.save(property);
        }
        return propertyService.checkTheDates(property).get(property);
    }
}
