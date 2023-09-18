package com.lowgistic.missionResponse.service.dto;

import com.lowgistic.missionResponse.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDto implements Serializable{
    private Long id;
    private String freightFrom;
    private String freightTo;
    private String freightType;
    private String freightTypeOfGoods;
    private LocalDate freightMissionStartDate;
    private LocalDate freightMissionEndDate;
    private LocalDate warehousingMissionStartDate;
    private LocalDate warehousingMissionEndDate;
    private String warehousingMissionCity;
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
    private Long companyId;
    private EStatus status;
    private boolean isWarehouseMission;
    private boolean isFreightMission;
}

