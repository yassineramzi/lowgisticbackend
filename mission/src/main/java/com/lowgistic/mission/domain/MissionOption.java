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
    private EMissionOptionType type;
}
