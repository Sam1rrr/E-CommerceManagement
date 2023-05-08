package com.example.ecommersmanagement.service.inter;

import com.example.ecommersmanagement.entity.Category;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CategoryServiceInter {
     void createCategory(Category category);
      List<Category> categoryList();
      void deleteCategory(Integer id);
     void updateCategory(Integer id,Category category);

    boolean findById(Integer id);
}
