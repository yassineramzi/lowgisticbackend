package com.lowgistic.mission.service.conditions.verifiers.impl;

import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifier;
import com.lowgistic.mission.service.dto.MissionDto;

import java.time.LocalDate;

public class FreightDateVerifier implements ConditionVerifier<MissionDto> {
    @Override
    public void verify(MissionDto createMissionDTO) {
        LocalDate freightStartDate = createMissionDTO.getFreightMissionStartDate();
        LocalDate freightEndDate = createMissionDTO.getFreightMissionEndDate();
        LocalDate currentDate = LocalDate.now();
        if (freightStartDate == null || freightStartDate.isBefore(currentDate)) {
            throw new IllegalArgumentException("Freight date should be specified and superior to today's date.");
        }
        if (freightEndDate == null || freightEndDate.isBefore(freightStartDate)) {
            throw new IllegalArgumentException("Freight end date should be specified and superior to freight start date.");
        }
    }
}
