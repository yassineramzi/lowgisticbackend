package com.lowgistic.missionResponse.service.dto;

import com.lowgistic.missionResponse.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionResponseDto implements Serializable {
    private Long id;
    private Long freightPrice;
    private String freightPriceCommentary;
    private Long freightIncotermsPrice;
    private String freightIncotermsCommentary;
    private String warehouseLocation;
    private Long storagePeriod;
    private Long storagePeriodPrice;
    private String storagePeriodCommentary;
    private Long franchiseStoragePeriod;
    private Date createDate;
    private CompanyDto owner;
    private EStatus status;
    private List<MissionResponseOptionDto> options;
    private MissionDto mission;
}
