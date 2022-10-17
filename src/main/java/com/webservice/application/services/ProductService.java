package com.webservice.application.services;

import com.webservice.application.entities.Product;
import com.webservice.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
       return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> productObject = productRepository.findById(id);
        return productObject.get();
    }
}
