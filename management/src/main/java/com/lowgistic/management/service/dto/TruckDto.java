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
public class TruckDto implements Serializable {
    private Long id;
    private String immatriculation;
    private String marque;
    private String model;
    private String year;
    private boolean refrigeration;
    private boolean liftGates;
    private boolean tieDowns;
    private boolean cargoPartitions;
    private boolean loadLocks;
}
