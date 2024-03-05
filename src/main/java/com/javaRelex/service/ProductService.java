package com.javaRelex.service;

import com.javaRelex.entity.Product;
import com.javaRelex.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public String addNewProduct(Product product) {
        repository.save(product);
        return "Товар " + product.getName() + " добавлен !";
    }

    public List<Product> allProduct() {
        return repository.findAll();
    }
}
