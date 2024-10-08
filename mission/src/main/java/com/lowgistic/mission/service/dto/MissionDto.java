package com.lowgistic.mission.service.dto;

import com.lowgistic.mission.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDto implements Serializable{
    private Long id;
    private Long freightFrom;
    private Long freightTo;
    private String freightType;
    private String freightTypeOfGoods;
    private LocalDate freightMissionStartDate;
    private LocalDate freightMissionEndDate;
    private LocalDate warehousingMissionStartDate;
    private LocalDate warehousingMissionEndDate;
    private Long warehousingMissionCity;
    private String pickupAddress;
    private String pickupContactPersonName;
    private String pickupContactPersonPhone;
    private String pickupContactPersonEmail;
    private boolean isPickupLoadingDockAvailable;
    private boolean isPickupLiftGateRequired;
    private String pickupSpecialInstructions;
    private String deliveryAddress;
    private String deliveryContactPersonName;
    private String deliveryContactPersonPhone;
    private String deliveryContactPersonEmail;
    private boolean isDeliveryLoadingDockAvailable;
    private boolean isDeliveryLiftGateRequired;
    private String deliverySpecialInstructions;
    private Integer numberOfUnits;
    private Integer shipementWeight;
    private String shipementUnit;
    private Integer shipementHeight;
    private Integer shipementLength;
    private Integer shipementWidth;
    private String shipementVolumeUnit;
    private List<MissionOptionDto> options;
    private Long companyId;
    private EStatus status;
    private boolean isWarehouseMission;
    private boolean isFreightMission;
    private String freightVehicleType;
    private MissionWarehouseOptionDto missionWarehouseOption;
}

