package com.lowgistic.gateway.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtDTO {
    private String token;
    private String type;
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
}
