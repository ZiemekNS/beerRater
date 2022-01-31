package com.example.beerRater;

import com.example.beerRater.domain.Beer;
import com.example.beerRater.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BeerRepository beerRepository;

    private final String title = "Baza piw";

    public List<Beer> findByKeyword(String keyword) {
        return beerRepository.findByKeyword(keyword);
    }

    @GetMapping("/")
    public String index(Model model, String keyword) {

        model.addAttribute("title", title);
        model.addAttribute("beers", beerRepository.findAll());

        if (keyword != null) {
            model.addAttribute("beers", beerRepository.findByKeyword(keyword));
        } else {
            model.addAttribute("title", title);
            model.addAttribute("beers", beerRepository.findAll());
        }
        return "index";
    }

    @GetMapping("/rate")
    public String rateBeerForm(Model model) {
        model.addAttribute("beer", new Beer());
        return "rate_form";
    }

    @GetMapping("/beer/view/{id}")
    public String singleBeerView(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("beer", beerRepository.findById(id).get());
        return "beer/view";
    }

    @PostMapping("/beer_rate")
    public String beerRating(Beer beer) {
        beerRepository.save(beer);
        return "rate_success";
    }
}
