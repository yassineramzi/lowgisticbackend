package com.lowgistic.mission.service.mapper;

import com.lowgistic.mission.domain.MissionOption;
import com.lowgistic.mission.service.dto.MissionOptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionOptionMapper extends EntityMapper<MissionOptionDto, MissionOption> {

    @Override
    MissionOptionDto toDto(MissionOption missionOption);

    @Override
    MissionOption toEntity(MissionOptionDto missionOptionDto);

    default MissionOption fromId(Long id) {
        if (id == null) {
            return null;
        }
        MissionOption missionOption = new MissionOption();
        missionOption.setId(id);
        return missionOption;
    }
}