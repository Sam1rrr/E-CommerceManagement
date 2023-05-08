package com.example.ecommersmanagement.service;

import com.example.ecommersmanagement.entity.Category;
import com.example.ecommersmanagement.repository.CategoryRepository;
import com.example.ecommersmanagement.repository.ProductRepository;
import com.example.ecommersmanagement.service.inter.CategoryServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceInter {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }


    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById((int) id);
        categoryRepository.delete(category);
    }

    public void updateCategory(Integer id, Category category) {


        Category category1 = categoryRepository.findById((int) id);
        category1.setCategoryName(category.getCategoryName());
        category1.setDescription(category.getDescription());
        category1.setImageUrl(category.getImageUrl());
        categoryRepository.save(category1);
    }

    @Override
    public boolean findById(Integer id) {
        return categoryRepository.findById(id).isPresent();
    }
}
