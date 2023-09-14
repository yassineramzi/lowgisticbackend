package com.lowgistic.mission.service.impl;

import com.lowgistic.mission.repository.CountryRepositroy;
import com.lowgistic.mission.service.CountryService;

import com.lowgistic.mission.service.dto.CountryDto;
import com.lowgistic.mission.service.mapper.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepositroy countryRepositroy;

    private final CountryMapper countryMapper;
    @Override
    public List<CountryDto> findByNameLike(String countryName) {
        return this.countryMapper.toDto(this.countryRepositroy.findByNameContainingIgnoreCase(countryName));
    }
}
