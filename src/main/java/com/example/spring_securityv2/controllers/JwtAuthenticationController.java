package com.example.spring_securityv2.controllers;


import com.example.spring_securityv2.config.JwtTokenUtil;
import com.example.spring_securityv2.models.JwtResponse;
import com.example.spring_securityv2.models.UserDAO;
import com.example.spring_securityv2.models.payload.LoginRequest;
import com.example.spring_securityv2.models.payload.SignUpRequest;
import com.example.spring_securityv2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateToken(@RequestBody LoginRequest loginRequest) throws Exception{

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));

    }


    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody SignUpRequest signUpRequest) throws Exception{
        return getResponseEntity(signUpRequest);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        UserDAO user = new UserDAO(signUpRequest.getUsername(),
                                    signUpRequest.getEmail(),
                                    encoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }



}
