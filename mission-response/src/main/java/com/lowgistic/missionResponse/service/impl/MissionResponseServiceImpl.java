package com.lowgistic.missionResponse.service.impl;

import com.lowgistic.missionResponse.domain.Company;
import com.lowgistic.missionResponse.domain.MissionResponse;
import com.lowgistic.missionResponse.enums.EStatus;
import com.lowgistic.missionResponse.exception.CompanyNotFoundException;
import com.lowgistic.missionResponse.repository.CompanyRepository;
import com.lowgistic.missionResponse.repository.MissionResponseRepositroy;
import com.lowgistic.missionResponse.service.MissionResponseService;
import com.lowgistic.missionResponse.service.dto.MissionResponseDto;
import com.lowgistic.missionResponse.service.mapper.MissionResponseMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MissionResponseServiceImpl implements MissionResponseService {

    private final Logger log = LoggerFactory.getLogger(MissionResponseServiceImpl.class);

    private final MissionResponseMapper missionResponseMapper;

    private final MissionResponseRepositroy missionResponseRepository;

    private final CompanyRepository companyRepository;

    @Override
    public MissionResponseDto update(final MissionResponseDto missionResponseDto, final Long companyId) throws CompanyNotFoundException {
        MissionResponse missionResponse = this.missionResponseMapper.toEntity(missionResponseDto);
        missionResponse.setOwner(getOwnerCompany(companyId));
        return this.missionResponseMapper.toDto(this.missionResponseRepository.save(missionResponse));
    }

    @Override
    public MissionResponseDto create(final MissionResponseDto missionResponseDto, final Long companyId) throws CompanyNotFoundException {
        MissionResponse missionResponse = this.missionResponseMapper.toEntity(missionResponseDto);
        missionResponse.setOwner(getOwnerCompany(companyId));
        return this.missionResponseMapper.toDto(this.missionResponseRepository.save(missionResponse));
    }

    // TODO : Add condition on company to verify if the mission is the company's mission
    @Override
    @Transactional(readOnly = true)
    public List<MissionResponseDto> findByMissionIdAndCompanyId(final Long missionId, final Long companyId) {
        return this.missionResponseMapper.toDto(this.missionResponseRepository.findByMissionIdAndStatus(missionId, EStatus.SUBMITTED));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MissionResponseDto> findSubmittedByCompany(final Long companyId) {
        return this.missionResponseMapper.toDto(this.missionResponseRepository.findByOwnerId(companyId));
    }

    private Company getOwnerCompany(final Long companyId) throws CompanyNotFoundException {
        return this.companyRepository.findById(companyId)
                .orElseThrow(() -> {
                    log.error("No company found with id: {}", companyId);
                    return new CompanyNotFoundException("No company found to submit a response for it: " + companyId);
                });
    }

}
