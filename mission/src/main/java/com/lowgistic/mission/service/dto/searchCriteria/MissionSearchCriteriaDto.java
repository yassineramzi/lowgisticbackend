package com.lowgistic.mission.service.dto.searchCriteria;

import lombok.Data;

import java.io.Serializable;

@Data
public class MissionSearchCriteriaDto implements Serializable {
    private Long freightOrigin;

    private Long freightDestination;

    private Long warehouseCity;

    private String missionType;
}
