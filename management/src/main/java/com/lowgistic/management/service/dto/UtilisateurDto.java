package com.lowgistic.management.service.dto;

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

    private String login;

    private String email;

    private String fixe;

    private String mobile;

    // @JsonIgnore
    private String password;

    private Set<RoleDto> roles;

    private SocieteDto societe;
}
