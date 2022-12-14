package com.youngboyandnunas.backend.global.security.service;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private final String secret;
    private final Long accessExp;
    private final Long refreshExp;

    public JwtProperties(String secret, Long accessExp, Long refreshExp) {
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
    }

}
