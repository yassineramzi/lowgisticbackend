package com.lowgistic.missionResponse.service.mapper;

import com.lowgistic.missionResponse.domain.MissionResponse;
import com.lowgistic.missionResponse.service.dto.MissionResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        MissionResponseOptionMapper.class,
        MissionMapper.class
})
public interface MissionResponseMapper extends EntityMapper<MissionResponseDto, MissionResponse> {

    @Override
    MissionResponseDto toDto(MissionResponse MissionResponse);

    @Override
    MissionResponse toEntity(MissionResponseDto missionResponseDTO);

    default MissionResponse fromId(Long id) {
        if (id == null) {
            return null;
        }
        MissionResponse MissionResponse = new MissionResponse();
        MissionResponse.setId(id);
        return MissionResponse;
    }
}