package com.lowgistic.mission.service.impl;

import com.lowgistic.mission.domain.Mission;
import com.lowgistic.mission.repository.MissionRepositroy;
import com.lowgistic.mission.service.MissionService;
import com.lowgistic.mission.service.conditions.utils.VerificationUtilsService;
import com.lowgistic.mission.service.conditions.verifiers.impl.MissionVerifiers;
import com.lowgistic.mission.service.dto.MissionDto;
import com.lowgistic.mission.service.dto.searchCriteria.MissionSearchCriteriaDto;
import com.lowgistic.mission.service.mapper.MissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionServiceImpl implements MissionService {

    private final MissionRepositroy missionRepository;

    private final MissionMapper missionMapper;

    /** Verifiers */
    private final MissionVerifiers missionVerifiers;

    @Autowired
    public MissionServiceImpl(final MissionRepositroy missionRepository, final MissionMapper missionMapper, final MissionVerifiers missionVerifiers) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
        this.missionVerifiers = missionVerifiers;
    }

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
        return this.missionMapper.toDto(this.missionRepository.findById(idMission).orElse(null));
    }

    /**
     * @param missionDto
     * @return
     */
    @Override
    public MissionDto update(MissionDto missionDto) {
        // verify the update of mission condition
        VerificationUtilsService.verifyConditions(missionDto,this.missionVerifiers.getUpdateVerifiers());
        Mission mission = this.missionMapper.toEntity(missionDto);
        return this.missionMapper.toDto(this.missionRepository.save(mission));
    }

    /**
     * @param missionDto
     * @return
     */
    @Override
    public MissionDto create(final MissionDto missionDto) {
        // verify the creation of mission condition
        VerificationUtilsService.verifyConditions(missionDto,this.missionVerifiers.getCreateVerifiers());
        Mission mission = this.missionMapper.toEntity(missionDto);
        return this.missionMapper.toDto(this.missionRepository.save(mission));
    }
}
