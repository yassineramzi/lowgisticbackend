package com.lowgistic.mission.service;

import com.lowgistic.mission.service.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> findByCountryIdAndNameLike(Long countryId, String cityName);
}
