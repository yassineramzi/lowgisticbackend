package com.lowgistic.mission.service.impl;

import com.lowgistic.mission.repository.MissionRepositroy;
import com.lowgistic.mission.service.MissionService;
import com.lowgistic.mission.service.dto.MissionDto;
import com.lowgistic.mission.service.dto.searchCriteria.MissionSearchCriteriaDto;
import com.lowgistic.mission.service.mapper.MissionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepositroy medecinRepository;

    private final MissionMapper medecinMapper;

    /**
     * @param missionSearchCriteriaDto 
     * @return
     */
    @Override
    public List<MissionDto> findByCriteria(MissionSearchCriteriaDto missionSearchCriteriaDto) {
        return null;
    }

    /**
     * @param idMission 
     * @return
     */
    @Override
    public MissionDto findById(Long idMission) {
        return null;
    }

    /**
     * @param MissionDto 
     * @return
     */
    @Override
    public MissionDto update(MissionDto MissionDto) {
        return null;
    }

    /**
     * @param MissionDto 
     * @return
     */
    @Override
    public MissionDto create(MissionDto MissionDto) {
        return null;
    }
}
