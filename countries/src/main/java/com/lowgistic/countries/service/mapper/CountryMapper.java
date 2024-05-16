package com.lowgistic.countries.service.mapper;

import com.lowgistic.countries.domain.Country;
import com.lowgistic.countries.service.dto.CountryDto;
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