package com.lowgistic.gateway.config;

import com.lowgistic.gateway.security.AuthenticationManager;
import com.lowgistic.gateway.security.SecurityContextRepository;
import com.lowgistic.gateway.security.exception.JwtExpiredTokenException;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {
    private static final String ROLE_ADMIN = "ADMIN";

    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .exceptionHandling()
                .authenticationEntryPoint((swe, e) -> {
                    if (e.getCause() instanceof JwtExpiredTokenException) {
                        swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    } else {
                        swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                    }
                    return Mono.empty();
                })
                .accessDeniedHandler((swe, e) ->
                        Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN))
                )
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .authorizeExchange()
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                /*
                    API Login
                 */
                .pathMatchers("/api/authentication/login").permitAll()
                /*
                    API Signup
                 */
                .pathMatchers("/api/management/register").permitAll()
                /*
                    API Company
                 */
                .pathMatchers("/api/management/company/**").hasRole(ROLE_ADMIN)
                /*
                    API Mission
                 */
                .pathMatchers("/api/mission/**").hasRole(ROLE_ADMIN)
                /*
                    API Mission Response
                 */
                .pathMatchers("/api/mission-response/**").hasRole(ROLE_ADMIN)
                /*
                    API Countries
                 */
                .pathMatchers("/api/countries/**").permitAll()
                /*
                    Pour tout autre appel, l'utilisateur doit être authentifié
                 */
                .anyExchange().authenticated()
                .and().build();
    }
}
