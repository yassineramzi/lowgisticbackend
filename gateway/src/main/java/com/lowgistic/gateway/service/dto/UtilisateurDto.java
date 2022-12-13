package com.lowgistic.gateway.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    @JsonIgnore
    private String password;

}
