package com.example.spring_securityv2.repository;

import com.example.spring_securityv2.models.UserDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDAO, String> {

    UserDAO findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
