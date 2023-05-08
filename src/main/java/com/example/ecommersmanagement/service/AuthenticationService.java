package com.example.ecommersmanagement.service;

import com.example.ecommersmanagement.entity.AuthenticationToken;
import com.example.ecommersmanagement.entity.User;
import com.example.ecommersmanagement.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final TokenRepository tokenRepository;
public void saveConfirmationToken(AuthenticationToken authenticationToken){
    tokenRepository.save(authenticationToken);
}
public AuthenticationToken getToken(User user){
    return tokenRepository.findByUser(user);
}




}
