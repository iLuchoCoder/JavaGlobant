package com.hermes.msg.dto;

public class JwtAuthResponseDTO {

    private String tokenAccess;
    private String typeToken = "Bearer";

    public JwtAuthResponseDTO(String tokenAccess) {
        this.tokenAccess = tokenAccess;
    }

    public JwtAuthResponseDTO(String tokenAccess, String typeToken) {
        super();
        this.tokenAccess = tokenAccess;
        this.typeToken = typeToken;
    }

    public String getTokenAccess() {
        return tokenAccess;
    }

    public void setTokenAccess(String tokenAccess) {
        this.tokenAccess = tokenAccess;
    }

    public String getTypeToken() {
        return typeToken;
    }

    public void setTypeToken(String typeToken) {
        this.typeToken = typeToken;
    }
}
