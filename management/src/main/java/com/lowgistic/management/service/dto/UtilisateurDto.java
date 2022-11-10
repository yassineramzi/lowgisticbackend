package com.lowgistic.management.service.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDto implements Serializable {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String pays;

    private String typeProfil;

    @JsonIgnore
    private String password;

    private Set<RoleDto> roles;

    private SocieteDto societe;
}
