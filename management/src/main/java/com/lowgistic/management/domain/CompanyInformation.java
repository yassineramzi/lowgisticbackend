package com.lowgistic.management.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "company_information")
@ToString
public class CompanyInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registreCommerce;
    private String numeroAgreement;
    private String numeroPoliceAssurance;
    private Integer nombreEmployes;
    private String deviseFacturation;
    private String logo;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn(name = "company_information_id")
    private List<Truck> trucks;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn(name = "company_information_id")
    private List<Warehouse> warehouses;

    @OneToOne
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company company;
}
