package com.lowgistic.countries.repository;

import com.lowgistic.countries.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
    List<City> findByNameContainingIgnoreCaseAndCountryId(String cityName, Long countryId);

    List<City> findByNameContainingIgnoreCase(String cityName);

}
