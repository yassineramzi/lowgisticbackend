package com.lowgistic.mission.domain;

import com.lowgistic.mission.enums.EMissionOptionType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "mission_option")
public class MissionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String translationKey;
    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private EMissionOptionType type;
}
