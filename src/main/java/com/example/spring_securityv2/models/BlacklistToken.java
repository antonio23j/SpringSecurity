package com.example.spring_securityv2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BlacklistToken {

    @Id
    String token;
}
