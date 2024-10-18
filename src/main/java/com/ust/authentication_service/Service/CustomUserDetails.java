package com.ust.authentication_service.Service;

import com.ust.authentication_service.Entity.UserCredentialsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String name;
    private String password;
    public CustomUserDetails(UserCredentialsEntity user){
        this.name = user.getUsername();
        this.password= user.getPassword();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public String getUsername(){
        return name;
    }

}
