package com.example.ecommersmanagement.controller;

import com.example.ecommersmanagement.common.ApiResponse;
import com.example.ecommersmanagement.dto.ProductDto;
import com.example.ecommersmanagement.entity.Category;
import com.example.ecommersmanagement.entity.Product;
import com.example.ecommersmanagement.repository.CategoryRepository;
import com.example.ecommersmanagement.service.ProductService;
import com.example.ecommersmanagement.service.inter.ProductServiceInter;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequestMapping(value = "/product", method = RequestMethod.POST)
@RestController
@RequiredArgsConstructor
@Builder
public class ProductController {

    private final ProductServiceInter productServiceInter;
    private final CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
        }
        productServiceInter.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true, "product has been added"), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        productServiceInter.deleteProduct(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "category dosen not exist"), HttpStatus.BAD_REQUEST);
        }
        productServiceInter.updateProduct(productDto, id);
        return new ResponseEntity<>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
    }

    @GetMapping("/list")

    public ResponseEntity<List<ProductDto>> listProducts() {
        List<ProductDto> products = productServiceInter.productList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
