package com.example.ecommersmanagement.controller;

import com.example.ecommersmanagement.common.ApiResponse;
import com.example.ecommersmanagement.entity.Category;
import com.example.ecommersmanagement.repository.CategoryRepository;
import com.example.ecommersmanagement.service.inter.CategoryServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceInter categoryServiceInter;
    private final CategoryRepository categoryRepository;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryServiceInter.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "a new category created"), HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> listCategory() {
        return categoryServiceInter.categoryList();

    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCategory(@PathVariable Integer id) {
        categoryServiceInter.deleteCategory(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") int id, @RequestBody Category category) {

        if (categoryServiceInter.findById(id)) {
            return new ResponseEntity<>(new ApiResponse(false, " category does not exist"), HttpStatus.NOT_FOUND);


        }
        categoryServiceInter.updateCategory(id, category);

        return new ResponseEntity<>(new ApiResponse(true, " category has been updated"), HttpStatus.ACCEPTED);
    }


}
