package com.lowgistic.missionResponse.service;

import com.lowgistic.missionResponse.exception.CompanyNotFoundException;
import com.lowgistic.missionResponse.service.dto.MissionResponseDto;

import java.util.List;

public interface MissionResponseService {

    MissionResponseDto update(final MissionResponseDto missionResponseDto, final Long companyId) throws CompanyNotFoundException;

    MissionResponseDto create(final MissionResponseDto missionResponseDto, final Long companyId) throws CompanyNotFoundException;

    List<MissionResponseDto> findByMissionIdAndCompanyId(final Long missionId, final Long companyId);

    List<MissionResponseDto> findSubmittedByCompany(final Long companyId);
}
