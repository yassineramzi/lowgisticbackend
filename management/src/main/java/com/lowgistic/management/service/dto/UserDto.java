package com.lowgistic.management.service.dto;

import lombok.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String password;

    private Set<RoleDto> roles = new HashSet<RoleDto>();

    private CompanyDto societe;
}
