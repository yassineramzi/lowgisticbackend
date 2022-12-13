package com.lowgistic.gateway.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "utilisateur",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
@DynamicUpdate
public class Utilisateur {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        private String nom;
    
        private String prenom;
    
        @Email
        private String email;
    
        private String telephone;
    
        private String pays;
    
        private String password;
    
        @Column(name="type_profil")
        private String typeProfil;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "utilisateur_roles",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles = new HashSet<>();

}
