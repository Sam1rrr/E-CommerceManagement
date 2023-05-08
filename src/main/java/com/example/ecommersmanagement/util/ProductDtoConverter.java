package com.example.ecommersmanagement.util;

import com.example.ecommersmanagement.dto.ProductDto;
import com.example.ecommersmanagement.entity.Product;

public class ProductDtoConverter {

public ProductDto converter(Product product){
    ProductDto productDto=ProductDto.builder()
            .brand(product.getBrand())
            .model(product.getModel())
            .price(product.getPrice())
            .build();
    return productDto;
}
}
