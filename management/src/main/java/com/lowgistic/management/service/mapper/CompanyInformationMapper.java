package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.CompanyInformation;
import com.lowgistic.management.service.dto.CompanyInformationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TruckMapper.class, WarehouseMapper.class})
public interface CompanyInformationMapper extends EntityMapper<CompanyInformationDto, CompanyInformation>{
    @Override
    CompanyInformationDto toDto(CompanyInformation companyInformation);

    @Override
    CompanyInformation toEntity(CompanyInformationDto companyInformationDTO);

    default CompanyInformation fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompanyInformation companyInformation = new CompanyInformation();
        companyInformation.setId(id);
        return companyInformation;
    }
}
