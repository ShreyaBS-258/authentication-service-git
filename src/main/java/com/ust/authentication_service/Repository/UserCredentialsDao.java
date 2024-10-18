package com.ust.authentication_service.Repository;

import com.ust.authentication_service.Entity.UserCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentialsEntity, Integer> {
    public Optional<UserCredentialsEntity> findByUsername(String username);
}
