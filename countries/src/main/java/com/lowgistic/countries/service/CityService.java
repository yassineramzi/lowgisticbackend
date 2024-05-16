package com.lowgistic.countries.service;

import com.lowgistic.countries.service.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> findByCountryIdAndNameLike(Long countryId, String cityName);

    List<CityDto> findByNameLike(String cityName);

    CityDto findById(Long cityId);
}
