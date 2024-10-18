package com.ust.authentication_service.Controller;

import com.ust.authentication_service.Entity.UserCredentialsEntity;
import com.ust.authentication_service.Service.JwtService;
import com.ust.authentication_service.Service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class UserCredentialsController {
    @Autowired
    private UserCredentialsService userCredService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/register")
    public UserCredentialsEntity register (@RequestBody UserCredentialsEntity user){
        return userCredService.register(user);
    }

    @GetMapping("/validate/{Token}")
    public ResponseEntity<String> validateToken(@PathVariable String Token) {
        boolean isValid = userCredService.validateToken(Token);
        if (isValid) {
            return ResponseEntity.ok("Token is valid.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid.");
        }
    }
    @PostMapping("/validate/user")
            public String getToken( @RequestBody UserCredentialsEntity user){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userCredService.generateToken(user.getUsername());
        } else {
            return null;
        }

    }}

