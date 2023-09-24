package com.lowgistic.missionResponse.service.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyInformationDto implements Serializable {
    private Long id;
    private String logo;
}
