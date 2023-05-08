package com.example.ecommersmanagement.controller;

import com.example.ecommersmanagement.dto.response.ResponseDto;
import com.example.ecommersmanagement.dto.user.SignInDto;
import com.example.ecommersmanagement.dto.user.SignInResponseDto;
import com.example.ecommersmanagement.dto.user.SignUpDto;
import com.example.ecommersmanagement.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceInter userServiceInter;

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto){

       return userServiceInter.signUp(signUpDto);
    }
    @PostMapping("/signin")
    public SignInResponseDto signin(@RequestBody SignInDto signInDto){
        return userServiceInter.signIn(signInDto);

    }


}