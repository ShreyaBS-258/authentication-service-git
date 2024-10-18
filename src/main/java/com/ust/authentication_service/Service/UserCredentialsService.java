package com.ust.authentication_service.Service;

import com.ust.authentication_service.Entity.UserCredentialsEntity;
import com.ust.authentication_service.Repository.UserCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {
    @Autowired
    UserCredentialsDao authDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    public UserCredentialsEntity register(UserCredentialsEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authDao.save(user);
    }

    public String generateToken (String name){
        return jwtService.generateToken(name);
    }

    public boolean validateToken(String token) {
        jwtService.validateToken(token);
        return true;
    }
}
