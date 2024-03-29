package dev.webservices.customerapi.Service;

import java.util.Optional;

import dev.webservices.addresses.Entity.Country;

public interface CountryService {

    Country save(Country country);

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    void update(Country country);

    void delete(Long id);

}
