package com.lowgistic.management.domain;

import com.lowgistic.management.enums.EStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "email_to_be_sent")
public class EmailToBeSent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String login;

    private String password;

    @Column(name="nom_societe")
    private String nomSociete;

    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private EStatus status;

    private String objet;
}
