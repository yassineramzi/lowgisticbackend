package com.lowgistic.mission.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "mission_warehouse_option")
@Data
@DynamicUpdate
@DynamicInsert
public class MissionWarehouseOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "superficie_min")
    private Double superficieMin;

    @Column(name = "is_bonded_warehouse")
    private Boolean isBondedWarehouse;

    @Column(name = "security247")
    private Boolean security247;

    @Column(name = "access247")
    private Boolean access247;

    @Column(name = "bunded")
    private Boolean bunded;

    @Column(name = "caged")
    private Boolean caged;

    @Column(name = "sprinklered")
    private Boolean sprinklered;

    @Column(name = "alarmed")
    private Boolean alarmed;

    @Column(name = "patrolled")
    private Boolean patrolled;

    @Column(name = "fenced_yard")
    private Boolean fencedYard;

    @Column(name = "cctv")
    private Boolean cctv;

    @Column(name = "esft")
    private Boolean esft;

    @Column(name = "bulk_powder")
    private Boolean bulkPowder;

    @Column(name = "hazardous_chemicals")
    private Boolean hazardousChemicals;

    @Column(name = "bulk_liquid")
    private Boolean bulkLiquid;

    @Column(name = "high_value")
    private Boolean highValue;

    @Column(name = "lme")
    private Boolean lme;

    @Column(name = "wet_bonded")
    private Boolean wetBonded;

    @Column(name = "dry_bonded")
    private Boolean dryBonded;

    @Column(name = "container")
    private Boolean container;

    @Column(name = "out_door")
    private Boolean outDoor;

    @Column(name = "rf_technology")
    private Boolean rfTechnology;

    @Column(name = "counter_balance")
    private Boolean counterBalance;

    @Column(name = "crane")
    private Boolean crane;

    @Column(name = "reach_truck")
    private Boolean reachTruck;

    @Column(name = "trailer_parking")
    private Boolean trailerParking;

    @Column(name = "brc")
    private Boolean brc;

    @Column(name = "organic_food_fed")
    private Boolean organicFoodFed;

    @Column(name = "mhra")
    private Boolean mhra;

    @Column(name = "organic_farmers")
    private Boolean organicFarmers;

    @Column(name = "soil")
    private Boolean soil;

    @Column(name = "ukwa")
    private Boolean ukwa;

    @Column(name = "cbp_supply_chain_security")
    private Boolean cbpSupplyChainSecurity;

    @OneToOne
    @JoinColumn(name = "mission_id", referencedColumnName = "id", updatable = false)
    private Mission mission;
}
