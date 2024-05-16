package com.lowgistic.countries.service.mapper;

import com.lowgistic.countries.domain.City;
import com.lowgistic.countries.service.dto.CityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends EntityMapper<CityDto, City> {

    @Override
    CityDto toDto(City city);

    @Override
    City toEntity(CityDto cityDto);

    default City fromId(Long id) {
        if (id == null) {
            return null;
        }
        City city = new City();
        city.setId(id);
        return city;
    }
}