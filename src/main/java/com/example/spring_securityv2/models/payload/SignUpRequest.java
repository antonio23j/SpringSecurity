package com.example.spring_securityv2.models.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String username;
    private String email;
    private String password;
}
