package com.javatechie.repository;

import com.javatechie.entity.Product;
import com.javatechie.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
