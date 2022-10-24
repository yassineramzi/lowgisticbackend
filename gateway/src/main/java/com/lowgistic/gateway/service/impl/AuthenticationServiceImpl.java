package com.lowgistic.gateway.service.impl;

import com.lowgistic.gateway.service.dto.JwtDTO;
import com.lowgistic.gateway.domain.Role;
import com.lowgistic.gateway.helper.JwtUtils;
import com.lowgistic.gateway.repository.UtilisateurRepository;
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

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public AuthenticationServiceImpl(
            JwtUtils jwtUtils,
            PasswordEncoder passwordEncoder,
            UtilisateurRepository utilisateurRepository
    ){
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Mono<JwtDTO> login(String login, String password) {
        AtomicReference<JwtDTO> jwtDTO = new AtomicReference<>();
        utilisateurRepository
                .findByLoginAndPassword(login, this.passwordEncoder.encode(password))
                .ifPresent(
                        utilisateur -> {
                            jwtDTO.set(new JwtDTO(
                                    jwtUtils.generateToken(utilisateur),
                                    "Bearer",
                                    utilisateur.getId(),
                                    utilisateur.getLogin(),
                                    utilisateur.getEmail(),
                                    utilisateur.getRoles().stream().map(Role::getNomRole).map(Enum::name).collect(Collectors.toList()
                                    )
                            ));
                        }
                );
        return Mono.justOrEmpty(jwtDTO.get());
    }
}
