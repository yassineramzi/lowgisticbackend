package com.lowgistic.mission.service.dto;

import com.lowgistic.mission.enums.EMissionOptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionOptionDto implements Serializable{
    private Long id;
    private String name;
    private String translationKey;
    private EMissionOptionType type;
}

