package com.lowgistic.management.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto implements Serializable {
    private Long id;

    private String raisonSociale;

    private String adresse;

    private String ice;

    private String typeProfil;

    private Long countryId;

    private CompanyInformationDto companyInformation;
}
