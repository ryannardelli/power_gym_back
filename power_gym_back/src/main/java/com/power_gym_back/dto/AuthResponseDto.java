package com.power_gym_back.dto;

public class AuthResponseDto {
    private String message;

    public AuthResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
