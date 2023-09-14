package com.lowgistic.missionResponse.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionResponseOptionDto implements Serializable {
    private Long id;
    private Long missionOptionId;
    private Long missionResponseId;
    private String commentary;
    private Long price;
}


