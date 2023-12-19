package com.example.spring_securityv2.services;

import com.example.spring_securityv2.models.UserDAO;
import com.example.spring_securityv2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDAO user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found!");
        }
        return JwtUserDetailsImpl.build(user);
    }
}
