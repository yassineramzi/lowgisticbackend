package com.lowgistic.countries.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable{
    private Long id;

    private String name;

    private String currency;

    private String emoji;

    private String iso3;

    private String iso2;

    private Integer numericCode;

    private String phoneCode;

    private String capital;

    private String currencyName;

    private String currencySymbol;
}

