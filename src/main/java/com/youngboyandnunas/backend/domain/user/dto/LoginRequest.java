package com.youngboyandnunas.backend.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
