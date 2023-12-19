package com.example.spring_securityv2.services;

import com.example.spring_securityv2.models.BlacklistToken;
import com.example.spring_securityv2.repository.BlacklistTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenBlacklistService {

    public final BlacklistTokenRepository blacklistTokenRepository;

    public void blacklistToken(String token){
        blacklistTokenRepository.save(new BlacklistToken(token));
    }

    public boolean isTokenBlacklisted(String token){
        return blacklistTokenRepository.existsById(token);
    }
}
