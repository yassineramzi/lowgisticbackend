package com.lowgistic.mission.service;

import com.lowgistic.mission.service.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> findByNameLike(String countryName);
}
