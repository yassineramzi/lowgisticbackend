package com.lowgistic.management.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "societe")
public class Societe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @OneToMany( mappedBy="societe", cascade = CascadeType.ALL )
    private List<Utilisateur> utilisateurs = new ArrayList<>();
}
