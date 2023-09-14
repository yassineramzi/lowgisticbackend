package com.lowgistic.management.service;

import com.lowgistic.management.service.dto.CompanyInformationDto;

public interface CompanyService {
    CompanyInformationDto create(CompanyInformationDto companyInformationDto, Long companyId);

    CompanyInformationDto findByCompanyId(Long companyId);
}
