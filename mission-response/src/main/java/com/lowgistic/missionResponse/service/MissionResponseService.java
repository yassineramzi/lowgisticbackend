package com.lowgistic.missionResponse.service;

import com.lowgistic.missionResponse.service.dto.MissionResponseDto;

import java.util.List;

public interface MissionResponseService {

    MissionResponseDto update(final MissionResponseDto missionResponseDto);

    MissionResponseDto create(final MissionResponseDto missionResponseDto);

    List<MissionResponseDto> findByMissionIdAndCompanyId(final Long missionId, final Long companyId);
}
