package com.power_gym_back.controllers;

import com.power_gym_back.dto.LoginRequestDto;
import com.power_gym_back.dto.RegisterRequestDto;
import com.power_gym_back.dto.AuthResponseDto;
import com.power_gym_back.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @Operation(summary = "Registra usuário")
    @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso!")
    public AuthResponseDto register(@RequestBody RegisterRequestDto dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "Realiza login do usuário")
    @ApiResponse(responseCode = "200", description = "Login feito com sucesso!")
    public AuthResponseDto login(@RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }
}
