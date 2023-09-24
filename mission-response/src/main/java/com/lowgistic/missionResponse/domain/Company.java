package com.lowgistic.missionResponse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne(mappedBy = "company")
    private CompanyInformation companyInformation;

}
