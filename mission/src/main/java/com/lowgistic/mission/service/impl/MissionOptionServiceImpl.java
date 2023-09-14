package com.lowgistic.mission.service.impl;

import com.lowgistic.mission.repository.MissionOptionRepositroy;
import com.lowgistic.mission.service.MissionOptionService;
import com.lowgistic.mission.service.dto.MissionOptionDto;
import com.lowgistic.mission.service.mapper.MissionOptionMapper;
import com.lowgistic.mission.web.resources.MissionApi;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MissionOptionServiceImpl implements MissionOptionService {
    private final Logger log = LoggerFactory.getLogger(MissionOptionServiceImpl.class);

    private final MissionOptionRepositroy missionOptionRepositroy;

    private final MissionOptionMapper missionOptionMapper;
    @Override
    public List<MissionOptionDto> findAll() {
        log.info("Get all mission's options");
        return missionOptionRepositroy.findAll().stream().map(missionOptionMapper::toDto).collect(Collectors.toList());
    }
}
