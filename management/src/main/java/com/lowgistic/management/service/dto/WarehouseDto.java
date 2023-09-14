package com.lowgistic.management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehouseDto implements Serializable {
    private Long id;
    private String name;
    private String address;
    private Double superficie;
    private boolean security247;
    private boolean access247;
    private boolean bunded;
    private boolean caged;
    private boolean sprinklered;
    private boolean alarmed;
    private boolean patrolled;
    private boolean fencedYard;
    private boolean cctv;
    private boolean esft;
    private boolean bulkPowder;
    private boolean hazardousChemicals;
    private boolean bulkLiquid;
    private boolean highValue;
    private boolean lme;
    private boolean wetBonded;
    private boolean dryBonded;
    private boolean container;
    private boolean outDoor;
    private boolean rfTechnology;
    private boolean counterBalance;
    private boolean crane;
    private boolean reachTruck;
    private boolean trailerParking;
    private boolean brc;
    private boolean organicFoodFed;
    private boolean mhra;
    private boolean organicFarmers;
    private boolean soil;
    private boolean ukwa;
    private boolean cbpSupplyChainSecurity;
}
