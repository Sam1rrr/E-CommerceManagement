package com.example.ecommersmanagement.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException (String msg){
        super(msg);
    }

}
