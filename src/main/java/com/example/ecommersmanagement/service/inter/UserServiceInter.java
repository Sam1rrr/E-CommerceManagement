package com.example.ecommersmanagement.service.inter;

import com.example.ecommersmanagement.dto.response.ResponseDto;
import com.example.ecommersmanagement.dto.user.SignInDto;
import com.example.ecommersmanagement.dto.user.SignInResponseDto;
import com.example.ecommersmanagement.dto.user.SignUpDto;

public interface UserServiceInter {
     ResponseDto signUp(SignUpDto signUpDto);
      SignInResponseDto signIn(SignInDto signInDto);
}
