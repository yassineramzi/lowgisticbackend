package com.lowgistic.mission.service.mapper;

import com.lowgistic.mission.domain.MissionWarehouseOption;
import com.lowgistic.mission.service.dto.MissionWarehouseOptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MissionWarehouseOptionMapper extends EntityMapper<MissionWarehouseOptionDto, MissionWarehouseOption> {

    @Override
    MissionWarehouseOptionDto toDto(MissionWarehouseOption missionWarehouseOption);

    @Override
    MissionWarehouseOption toEntity(MissionWarehouseOptionDto missionWarehouseOptionDto);

    default MissionWarehouseOption fromId(Long id) {
        if (id == null) {
            return null;
        }
        MissionWarehouseOption missionWarehouseOption = new MissionWarehouseOption();
        missionWarehouseOption.setId(id);
        return missionWarehouseOption;
    }
}