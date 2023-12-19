package com.example.spring_securityv2.repository;

import com.example.spring_securityv2.models.BlacklistToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlacklistTokenRepository extends MongoRepository<BlacklistToken, String> {
}
