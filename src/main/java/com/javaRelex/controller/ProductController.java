package com.javaRelex.controller;

import com.javaRelex.entity.Product;
import com.javaRelex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/addNewProduct")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @GetMapping("/allProduct")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public List<Product> allProduct() {
        return productService.allProduct();
    }

}
