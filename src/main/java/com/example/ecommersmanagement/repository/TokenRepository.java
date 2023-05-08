package com.example.ecommersmanagement.repository;

import com.example.ecommersmanagement.entity.AuthenticationToken;
import com.example.ecommersmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken,Integer > {
    AuthenticationToken findByUser(User user);
}
