package com.lowgistic.mission.service.impl;

import com.lowgistic.mission.repository.CityRepository;
import com.lowgistic.mission.service.CityService;
import com.lowgistic.mission.service.dto.CityDto;
import com.lowgistic.mission.service.mapper.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final CityMapper cityMapper;
    @Override
    public List<CityDto> findByCountryIdAndNameLike(Long countryId, String cityName) {
        return this.cityMapper.toDto(this.cityRepository.findByNameContainingIgnoreCaseAndCountryId(cityName, countryId));
    }
}
