package com.example.ecommersmanagement.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductDto {
    private Integer id;
    private String brand;
    private String model;
    private double price;
    private @NotNull Integer categoryId;


}
