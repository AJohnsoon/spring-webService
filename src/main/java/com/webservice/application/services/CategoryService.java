package com.webservice.application.services;

import com.webservice.application.entities.Category;
import com.webservice.application.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> objectCategory = categoryRepository.findById(id);
        return objectCategory.get();
    }
}
