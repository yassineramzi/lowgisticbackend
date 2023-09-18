package com.lowgistic.missionResponse.domain;

import com.lowgistic.missionResponse.enums.EStatus;
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
@Table(name = "mission_response")
public class MissionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "freight_price")
    private Long freightPrice;

    @Column(name = "freight_price_commentary")
    private String freightPriceCommentary;

    @Column(name = "freight_incoterms_price")
    private Long freightIncotermsPrice;

    @Column(name = "freight_incoterms_commentary")
    private String freightIncotermsCommentary;

    @Column(name = "warehouse_location")
    private String warehouseLocation;

    @Column(name = "storage_period")
    private Long storagePeriod;

    @Column(name = "storage_period_price")
    private Long storagePeriodPrice;

    @Column(name = "storage_period_commentary")
    private String storagePeriodCommentary;

    @Column(name = "franchise_storage_period")
    private Long franchiseStoragePeriod;

    @Column(name = "create_date")
    private Date createDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private EStatus status;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn(name = "mission_response_id")
    private List<MissionResponseOption> options;

    @ManyToOne
    @JoinColumn(name="mission_id", referencedColumnName = "id", updatable = false)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name="owner_id", referencedColumnName = "id", updatable = false)
    private Company owner;
}
