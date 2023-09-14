package com.lowgistic.mission.service.mapper;

import com.lowgistic.mission.domain.Country;
import com.lowgistic.mission.service.dto.CountryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
CityMapper.class
})
public interface CountryMapper extends EntityMapper<CountryDto, Country> {

    @Override
    CountryDto toDto(Country Country);

    @Override
    Country toEntity(CountryDto countryDTO);

    default Country fromId(Long id) {
        if (id == null) {
            return null;
        }
        Country Country = new Country();
        Country.setId(id);
        return Country;
    }
}