package com.lowgistic.missionResponse.service.mapper;

import com.lowgistic.missionResponse.domain.Mission;
import com.lowgistic.missionResponse.service.dto.MissionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionMapper extends EntityMapper<MissionDto, Mission> {

    @Override
    MissionDto toDto(Mission Mission);

    @Override
    Mission toEntity(MissionDto MissionDTO);

    default Mission fromId(Long id) {
        if (id == null) {
            return null;
        }
        Mission Mission = new Mission();
        Mission.setId(id);
        return Mission;
    }
}