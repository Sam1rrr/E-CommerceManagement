package com.example.ecommersmanagement.dto.user;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
