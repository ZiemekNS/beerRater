package com.example.beerRater;

import com.example.beerRater.domain.Property;
import com.example.beerRater.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private PropertyRepository propertyRepository;

    @Autowired
    public DataLoader(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        propertyRepository.save(new Property("Domek nad sosnami", "Mietek", LocalDate.of(2020,1,8), LocalDate.of(2020,1,12)));
        propertyRepository.save(new Property("Rezydencja Rockefellera", "Wojtek", LocalDate.of(2020,2,4), LocalDate.of(2020,2,15)));
        propertyRepository.save(new Property("Domek nad jeziorkiem", "Basia", LocalDate.of(2020,3,20), LocalDate.of(2020,4,4)));
        propertyRepository.save(new Property("Chatka Puchatka", "Marcin", LocalDate.of(2020,4,1), LocalDate.of(2021,4,7)));
        propertyRepository.save(new Property("Domek nad sosnami", "Mietek", LocalDate.of(2021,5,2), LocalDate.of(2021,5,8)));
        propertyRepository.save(new Property("Domek nad jeziorkiem", "Basia", LocalDate.of(2021,6,3), LocalDate.of(2021,6,9)));
        propertyRepository.save(new Property("Karczma pod Różowym Pawianem", "Mietek", LocalDate.of(2022,1,15), LocalDate.of(2022,1,20)));
    }
}
