package com.lowgistic.missionResponse.service.mapper;

import com.lowgistic.missionResponse.domain.MissionResponseOption;
import com.lowgistic.missionResponse.service.dto.MissionResponseOptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionResponseOptionMapper extends EntityMapper<MissionResponseOptionDto, MissionResponseOption> {

    @Override
    MissionResponseOptionDto toDto(MissionResponseOption missionOption);

    @Override
    MissionResponseOption toEntity(MissionResponseOptionDto missionResponseOptionDto);

    default MissionResponseOption fromId(Long id) {
        if (id == null) {
            return null;
        }
        MissionResponseOption missionOption = new MissionResponseOption();
        missionOption.setId(id);
        return missionOption;
    }
}