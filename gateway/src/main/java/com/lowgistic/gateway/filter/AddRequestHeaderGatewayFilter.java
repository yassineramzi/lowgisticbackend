package com.lowgistic.gateway.filter;

import com.lowgistic.gateway.domain.User;
import com.lowgistic.gateway.helper.JwtUtils;
import com.lowgistic.gateway.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AddRequestHeaderGatewayFilter implements GlobalFilter {

    private final Logger log = LoggerFactory.getLogger(AddRequestHeaderGatewayFilter.class);
    private final JwtUtils jwtUtil;

    private final UserRepository userRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Global Filter activated ");
        ServerWebExchange exchange1 = exchange;
        try {
            List<String> authorizationHeaders = exchange.getRequest().getHeaders().get("Authorization");
            Optional<User> userOptional = Optional.empty();
            if (authorizationHeaders != null && !authorizationHeaders.isEmpty()) {
                String jwtToken = authorizationHeaders.get(0);
                if (jwtToken != null && jwtToken.length() > 7) {
                    log.info("Getting company for TOKEN : {}", jwtToken);
                    String email = this.jwtUtil.getUsernameFromToken(jwtToken.substring(7));
                    userOptional = this.userRepository.findByEmail(email);
                }
            }
            if(userOptional.isPresent()) {
                User user = userOptional.get();
                log.info("Getting company : {} by login : {}  ", user.getCompany().getRaisonSociale(), user.getEmail() );
                ServerHttpRequest request = exchange.getRequest()
                        .mutate()
                        .header("X-COMPANY-ID", String.valueOf(user.getCompany().getId()))
                        .build();
                exchange1 = exchange.mutate().request(request).build();
            }
        }catch(Exception e) {
            log.error("An error occured while getting the company : {}", e);
        }
        return chain.filter(exchange1);
    }
}
