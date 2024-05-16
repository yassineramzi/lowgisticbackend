package com.lowgistic.countries.web.resources;

import com.lowgistic.countries.service.CityService;
import com.lowgistic.countries.service.CountryService;
import com.lowgistic.countries.service.dto.CityDto;
import com.lowgistic.countries.service.dto.CountryDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class CountryApi {
    private final Logger log = LoggerFactory.getLogger(CountryApi.class);

    private final CountryService countryService;

    private final CityService cityService;

    @GetMapping("/{countryName}")
    public List<CountryDto> findCountriesByNameLike(@PathVariable("countryName") final String countryName) {
        log.info("Find countries by name like : {} ", countryName);
        return countryService.findByNameLike(countryName);
    }

    @GetMapping("/{idCountry}/cities/{cityName}")
    public List<CityDto> findCitiesByNameLike(@PathVariable("idCountry") final Long idCountry, @PathVariable("cityName") final String cityName) {
        log.info("Find cities by name like : {} and country id : {}", cityName,idCountry);
        return cityService.findByCountryIdAndNameLike(idCountry, cityName);
    }

    @GetMapping("/cities/{cityName}")
    public List<CityDto> findCitiesByNameLike(@PathVariable("cityName") final String cityName) {
        log.info("Find cities by name like : {}", cityName);
        return cityService.findByNameLike(cityName);
    }

    @GetMapping("/cities/{id}")
    public CityDto findCityById(@PathVariable("id") final Long cityId) {
        log.info("Find city by id : {}", cityId);
        return cityService.findById(cityId);
    }
}
