package com.lowgistic.management.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "societe")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="raison_sociale")
    private String raisonSociale;

    private String adresse;

    private String ice;

    @Column(name="type_profil")
    private String typeProfil;

    private Long countryId;

    @OneToOne(mappedBy = "company")
    private CompanyInformation companyInformation;
}
