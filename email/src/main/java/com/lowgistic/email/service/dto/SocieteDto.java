package com.lowgistic.email.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocieteDto implements Serializable {
    private Long id;

    private String raisonSociale;

    private String adresse;

    private String ice;
}
