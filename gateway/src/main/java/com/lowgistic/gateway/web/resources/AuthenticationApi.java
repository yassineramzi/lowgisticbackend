package com.lowgistic.gateway.web.resources;

import com.lowgistic.gateway.service.dto.JwtDTO;
import com.lowgistic.gateway.service.dto.LoginRequestDTO;
import com.lowgistic.gateway.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApi {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationApi(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<JwtDTO>> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return authenticationService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
                .map(jwtDTO -> ResponseEntity.ok(jwtDTO))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
}
