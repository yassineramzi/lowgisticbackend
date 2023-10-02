package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.Company;
import com.lowgistic.management.service.dto.CompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CompanyInformationMapper.class})
public interface SocieteMapper extends EntityMapper<CompanyDto, Company>{
    @Override
    CompanyDto toDto(Company Societe);

    @Override
    Company toEntity(CompanyDto SocieteDTO);

    default Company fromId(Long id) {
        if (id == null) {
            return null;
        }
        Company Societe = new Company();
        Societe.setId(id);
        return Societe;
    }
}
