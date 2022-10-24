package com.lowgistic.management.service.dto;

import com.lowgistic.management.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable{
    private ERole nomRole;
}
