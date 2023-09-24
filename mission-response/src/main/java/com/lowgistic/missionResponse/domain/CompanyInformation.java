package com.lowgistic.missionResponse.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    private String logo;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
