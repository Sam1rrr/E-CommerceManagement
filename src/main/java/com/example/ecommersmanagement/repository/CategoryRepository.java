package com.example.ecommersmanagement.repository;

import com.example.ecommersmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category ,Integer > {
    Category findById(int id);
}
