package com.lowgistic.mission.domain;

import com.lowgistic.mission.enums.EStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String freightFrom;
    private String freightTo;
    private String freightType;
    private String freightTypeOfGoods;
    private Date freightMissionStartDate;
    private Date freightMissionEndDate;
    private Date warehousingMissionStartDate;
    private Date warehousingMissionEndDate;
    private String warehousingMissionCity;
    private String pickupAddress;
    private String pickupContactPersonName;
    private String pickupContactPersonPhone;
    private String pickupContactPersonEmail;
    private boolean isPickupLoadingDockAvailable;
    private boolean isPickupLiftGateRequired;
    private String pickupSpecialInstructions;
    private String deliveryAddress;
    private String deliveryContactPersonName;
    private String deliveryContactPersonPhone;
    private String deliveryContactPersonEmail;
    private boolean isDeliveryLoadingDockAvailable;
    private boolean isDeliveryLiftGateRequired;
    private String deliverySpecialInstructions;
    private Integer numberOfUnits;
    private Integer shipementWeight;
    private String shipementUnit;
    private Integer shipementHeight;
    private Integer shipementLength;
    private Integer shipementWidth;
    private String shipementVolumeUnit;
    @ManyToMany
    @JoinTable(
            name = "mission_mission_option",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_option_id")
    )
    private List<MissionOption> options;
    private Long companyId;
    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private EStatus status;
    private boolean isWarehouseMission;
    private boolean isFreightMission;
}

