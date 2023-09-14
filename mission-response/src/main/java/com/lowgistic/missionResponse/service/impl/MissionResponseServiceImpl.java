package com.lowgistic.missionResponse.service.impl;

import com.lowgistic.missionResponse.domain.MissionResponse;
import com.lowgistic.missionResponse.enums.EStatus;
import com.lowgistic.missionResponse.repository.MissionResponseRepositroy;
import com.lowgistic.missionResponse.service.MissionResponseService;
import com.lowgistic.missionResponse.service.dto.MissionResponseDto;
import com.lowgistic.missionResponse.service.mapper.MissionResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MissionResponseServiceImpl implements MissionResponseService {

    private final MissionResponseRepositroy missionResponseRepository;

    private final MissionResponseMapper missionResponseMapper;

    @Override
    public MissionResponseDto update(final MissionResponseDto missionResponseDto) {
        MissionResponse missionResponse = this.missionResponseMapper.toEntity(missionResponseDto);
        return this.missionResponseMapper.toDto(this.missionResponseRepository.save(missionResponse));
    }

    @Override
    public MissionResponseDto create(final MissionResponseDto missionResponseDto) {
        MissionResponse missionResponse = this.missionResponseMapper.toEntity(missionResponseDto);
        return this.missionResponseMapper.toDto(this.missionResponseRepository.save(missionResponse));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MissionResponseDto> findByMissionIdAndCompanyId(Long missionId, Long companyId) {
        return this.missionResponseMapper.toDto(this.missionResponseRepository.findByMissionIdAndStatus(missionId, EStatus.SUBMITTED));
    }

}
