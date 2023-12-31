package dev.webservices.customerapi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.customerapi.Entity.City;
import dev.webservices.customerapi.Service.CityService;
import dev.webservices.customerapi.Service.CountryService;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    // Save city in the database
    @PostMapping("/")
    public String saveCity(@RequestBody City city) {
        cityService.save(city);
        return "Saved successfully!";
    }

    // Find city by ID
    @GetMapping("/")
    public City getCity(@RequestParam Long id) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(id);
        if (cityId.isPresent()) {
            return cityService.findById(id).get();
        } else {
            return null;
        }
    }

    // Update city data
    @PutMapping("/")
    public String updateCity(@RequestBody City city) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(city.getId());
        if (cityId.isPresent()) {
            cityService.update(city);
            return "City updated successfully!";
        } else {
            return "City not found!";
        }

    }

    // Delete city
    @DeleteMapping("/")
    public String deleteCity(@RequestParam Long id) {

        // Check if the city with the given ID present
        Optional<City> cityId = cityService.findById(id);
        if (cityId.isPresent()) {
            cityService.delete(id);
            countryService.delete(id);
            return "City/Country record deleted successfully!";
        } else {
            return "City not found!";
        }
    }
}
