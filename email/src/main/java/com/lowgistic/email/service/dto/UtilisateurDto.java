package com.lowgistic.email.service.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Set;

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

    private String password;

    private Set<RoleDto> roles;

    private SocieteDto societe;
}
