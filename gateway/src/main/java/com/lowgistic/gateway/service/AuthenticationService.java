package com.lowgistic.gateway.service;

import com.lowgistic.gateway.service.dto.JwtDTO;
import reactor.core.publisher.Mono;

public interface AuthenticationService {
    Mono<JwtDTO> login(String login, String password);
}
