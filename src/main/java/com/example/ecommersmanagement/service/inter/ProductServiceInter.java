package com.example.ecommersmanagement.service.inter;

import com.example.ecommersmanagement.dto.ProductDto;
import com.example.ecommersmanagement.entity.Category;

import java.util.List;

public interface ProductServiceInter {
//     void createProduct(Product product);
     void deleteProduct(Integer id);
     List<ProductDto> productList();
     void updateProduct(ProductDto productDto, Integer id) throws Exception;

     void createProduct(ProductDto productDto, Category category);

//     void createProduct(ProductDto productDto, Optional<Category> category);
}
