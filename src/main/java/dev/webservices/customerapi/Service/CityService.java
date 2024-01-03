package dev.webservices.customerapi.Service;

import java.util.Optional;

import dev.webservices.customerapi.Entity.City;

public interface CityService {

    City save(City city);

    Optional<City> findById(Long id);

    void update(Long id);

    void delete(Long id);

}