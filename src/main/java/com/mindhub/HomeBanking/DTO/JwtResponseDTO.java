package com.mindhub.HomeBanking.DTO;

public class JwtResponseDTO {

    private final String token;

    public JwtResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}