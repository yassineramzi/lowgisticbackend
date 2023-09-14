package com.lowgistic.management.service.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyInformationDto implements Serializable {
    private Long id;
    private String registreCommerce;
    private String numeroAgreement;
    private String numeroPoliceAssurance;
    private Integer nombreEmployes;
    private String deviseFacturation;
    private List<TruckDto> trucks;
    private List<WarehouseDto> warehouses;
    private List<String> routes;
}
