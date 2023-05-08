package com.example.ecommersmanagement.exception;

import org.apache.naming.StringManager;

public class CustomException extends IllegalArgumentException{
    public CustomException(String msg){
        super(msg);
    }
}
