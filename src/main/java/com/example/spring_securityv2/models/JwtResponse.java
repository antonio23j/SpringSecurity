package com.example.spring_securityv2.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponse {
    private final String jwtToken;
}
