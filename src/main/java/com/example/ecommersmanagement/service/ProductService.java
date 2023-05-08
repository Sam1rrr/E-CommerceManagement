package com.example.ecommersmanagement.service;

import com.example.ecommersmanagement.dto.ProductDto;
import com.example.ecommersmanagement.entity.Category;
import com.example.ecommersmanagement.entity.Product;
import com.example.ecommersmanagement.repository.ProductRepository;
import com.example.ecommersmanagement.service.inter.ProductServiceInter;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class ProductService implements ProductServiceInter {
    private final ProductRepository productRepository;

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setBrand(product.getBrand());
        productDto.setModel(product.getModel());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setId(productDto.getId());

        return productDto;
    }

    public void deleteProduct(Integer id) {
        Product product = productRepository.findById((int) id);
        productRepository.delete(product);
    }

    public List<ProductDto> productList() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    @Override
    public void updateProduct(ProductDto productDto, Integer id) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product does not exist");
        }

        Product product = optionalProduct.get();
        product.setBrand(productDto.getBrand());
        product.setModel(productDto.getModel());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    @Override
    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setBrand(productDto.getBrand());
        product.setModel(productDto.getModel());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepository.save(product);


    }

//    @Override
//    public void createProduct(ProductDto productDto, Optional<Category> category) {
//        productRepository.save(productDto);
//
//    }

}
