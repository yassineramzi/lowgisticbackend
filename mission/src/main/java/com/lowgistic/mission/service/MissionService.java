package com.lowgistic.mission.service;

import com.lowgistic.mission.service.dto.MissionDto;
import com.lowgistic.mission.service.dto.searchCriteria.MissionSearchCriteriaDto;

import java.util.List;

public interface MissionService {
    List<MissionDto> findByCompany(Long idCompany);

    List<MissionDto> findAllForSeller(Long idCompanySeller);
    MissionDto findById(final Long idMission);
    MissionDto update(final MissionDto MissionDto);
    MissionDto create(final MissionDto MissionDto);
}
