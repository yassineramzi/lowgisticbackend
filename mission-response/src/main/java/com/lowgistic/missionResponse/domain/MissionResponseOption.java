package com.lowgistic.missionResponse.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "mission_response_option")
public class MissionResponseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mission_option_id")
    private Long missionOptionId;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name="mission_response_id", referencedColumnName = "id")
    private MissionResponse missionResponse;
}
