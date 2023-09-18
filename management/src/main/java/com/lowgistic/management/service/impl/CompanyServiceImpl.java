package com.lowgistic.management.service.impl;

import com.lowgistic.management.domain.CompanyInformation;
import com.lowgistic.management.repository.CompanyInformationRepository;
import com.lowgistic.management.repository.CompanyRepository;
import com.lowgistic.management.service.CompanyService;
import com.lowgistic.management.service.dto.CompanyDto;
import com.lowgistic.management.service.dto.CompanyInformationDto;
import com.lowgistic.management.service.mapper.CompanyInformationMapper;
import com.lowgistic.management.service.mapper.SocieteMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

    private final CompanyRepository companyRepository;

    private final CompanyInformationRepository companyInformationRepository;

    private final CompanyInformationMapper companyInformationMapper;

    private final SocieteMapper societeMapper;

    @Override
    public CompanyInformationDto create(final CompanyInformationDto companyInformationDto, final Long companyId) {
        log.info("Request to save Company Information : {} for company : {}", companyInformationDto, companyId);
        return companyRepository.findById(companyId)
                .map(company -> {
                    CompanyInformation companyInformation = companyInformationMapper.toEntity(companyInformationDto);
                    companyInformation.setCompany(company);
                    companyInformation = companyInformationRepository.save(companyInformation);
                    return companyInformationMapper.toDto(companyInformation);
                })
                .orElseGet(() -> {
                    log.error("No company found with id: {}", companyId);
                    return null; // or throw an exception as needed
                });
    }

    @Override
    public CompanyInformationDto findCompanyInformationByCompanyId(final Long companyId) {
        log.info("Find Company information for company : {}", companyId);
        return companyInformationRepository.findByCompanyId(companyId)
                .map(companyInformation -> {
                    return companyInformationMapper.toDto(companyInformation);
                })
                .orElseGet(() -> {
                    log.error("No company information found with id: {}", companyId);
                    return null;
                });
    }

    @Override
    public CompanyDto findByCompanyId(final Long companyId) {
        log.info("Find company information : {}", companyId);
        return companyRepository.findById(companyId)
                .map(company -> {
                    return societeMapper.toDto(company);
                })
                .orElseGet(() -> {
                    log.error("No company found with id: {}", companyId);
                    return null;
                });
    }
}
