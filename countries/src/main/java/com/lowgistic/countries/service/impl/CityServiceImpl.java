package com.lowgistic.countries.service.impl;

import com.lowgistic.countries.repository.CityRepository;
import com.lowgistic.countries.service.CityService;
import com.lowgistic.countries.service.dto.CityDto;
import com.lowgistic.countries.service.mapper.CityMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    private final CityRepository cityRepository;

    private final CityMapper cityMapper;
    @Override
    public List<CityDto> findByCountryIdAndNameLike(Long countryId, String cityName) {
        return this.cityMapper.toDto(this.cityRepository.findByNameContainingIgnoreCaseAndCountryId(cityName, countryId));
    }

    @Override
    public List<CityDto> findByNameLike(String cityName) {
        return this.cityMapper.toDto(this.cityRepository.findByNameContainingIgnoreCase(cityName));
    }

    @Override
    public CityDto findById(Long cityId) {
        return this.cityRepository.findById(cityId)
                .map(cityMapper::toDto)
                .orElseGet(() -> {
                    log.error("No city found with id: {}", cityId);
                    return null;
                });
    }
}
