package com.lowgistic.mission.service.dto;

import lombok.Data;

@Data
public class MissionWarehouseOptionDto {
    private Long id;
    private Double superficieMin;
    private Boolean isBondedWarehouse;
    private Boolean security247;
    private Boolean access247;
    private Boolean bunded;
    private Boolean caged;
    private Boolean sprinklered;
    private Boolean alarmed;
    private Boolean patrolled;
    private Boolean fencedYard;
    private Boolean cctv;
    private Boolean esft;
    private Boolean bulkPowder;
    private Boolean hazardousChemicals;
    private Boolean bulkLiquid;
    private Boolean highValue;
    private Boolean lme;
    private Boolean wetBonded;
    private Boolean dryBonded;
    private Boolean container;
    private Boolean outDoor;
    private Boolean rfTechnology;
    private Boolean counterBalance;
    private Boolean crane;
    private Boolean reachTruck;
    private Boolean trailerParking;
    private Boolean brc;
    private Boolean organicFoodFed;
    private Boolean mhra;
    private Boolean organicFarmers;
    private Boolean soil;
    private Boolean ukwa;
    private Boolean cbpSupplyChainSecurity;
}
