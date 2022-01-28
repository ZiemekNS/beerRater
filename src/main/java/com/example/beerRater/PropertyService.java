package com.example.beerRater;

import com.example.beerRater.domain.Property;
import com.example.beerRater.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public HashMap<Property, String> checkTheDates(Property property) {
        String result = "submit_success";
        HashMap<Property, String> resultMap = new HashMap<>();

        List<Integer> placeOfObject = new ArrayList<>();

        if (property.getReservationEndDate().isBefore(property.getReservationStartDate())) {
            throw new IllegalStateException("Niestety data końcowa musi być późniejsza od daty początkowej");
        }

        List<Property> listOfStartDates = propertyRepository.findAll();
        for (int j = 0; j < listOfStartDates.size(); j++) {
            if (property.getPropertyName().equals(listOfStartDates.get(j).getPropertyName())) {
                placeOfObject.add(j);
            }
        }

        for (int k = 0; k < placeOfObject.size(); k++) {
            if ((property.getReservationStartDate().isBefore(listOfStartDates.get(placeOfObject.get(k)).getReservationEndDate()) &&
                    (property.getReservationStartDate().isAfter(listOfStartDates.get(placeOfObject.get(k)).getReservationStartDate().minusDays(1)))) ||
            ((property.getReservationEndDate().isBefore(listOfStartDates.get(placeOfObject.get(k)).getReservationEndDate())) &&
                    (property.getReservationEndDate().isAfter(listOfStartDates.get(placeOfObject.get(k)).getReservationStartDate().minusDays(1))))) {
                throw new IllegalStateException("Niestety termin jest już zajęty");
            }
        }
        resultMap.put(property, result);

        return resultMap;
    }
}
