package com.lowgistic.gateway.service.impl;

import com.lowgistic.gateway.service.dto.JwtDTO;
import com.lowgistic.gateway.domain.Role;
import com.lowgistic.gateway.helper.JwtUtils;
import com.lowgistic.gateway.repository.UserRepository;
import com.lowgistic.gateway.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(
            JwtUtils jwtUtils,
            PasswordEncoder passwordEncoder,
            UserRepository userRepository
    ){
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<JwtDTO> login(String login, String password) {
        AtomicReference<JwtDTO> jwtDTO = new AtomicReference<>();
        userRepository
                .findByEmailAndPassword(login, this.passwordEncoder.encode(password))
                .ifPresent(
                        user -> {
                            jwtDTO.set(new JwtDTO(
                                    jwtUtils.generateToken(user),
                                    "Bearer",
                                    user.getId(),
                                    user.getEmail(),
                                    user.getRoles().stream().map(Role::getNomRole).map(Enum::name).collect(Collectors.toList()
                                    )
                            ));
                        }
                );
        return Mono.justOrEmpty(jwtDTO.get());
    }
}
