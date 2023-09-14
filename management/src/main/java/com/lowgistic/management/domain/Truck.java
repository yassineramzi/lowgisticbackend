package com.lowgistic.management.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "truck")
public class Truck implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    private CompanyInformation companyInformation;
}
