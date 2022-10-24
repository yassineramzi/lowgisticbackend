package com.lowgistic.management.domain;

import com.lowgistic.management.enums.EStatusTenant;
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
@Table(name = "tenant")
public class Tenant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private EStatusTenant status;

    @OneToOne
    @JoinColumn(name="id_societe")
    private Societe societe;
}
