package com.lowgistic.countries.service;

import com.lowgistic.countries.service.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> findByNameLike(String countryName);
}
