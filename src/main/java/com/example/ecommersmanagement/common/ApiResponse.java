package com.example.ecommersmanagement.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ApiResponse {
    private final boolean success;
    private final String message;
public String getTimestamp(){
    return LocalDateTime.now().toString();
}
}
