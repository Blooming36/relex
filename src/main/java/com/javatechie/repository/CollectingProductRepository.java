package com.javatechie.repository;

import com.javatechie.entity.CollectingProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CollectingProductRepository extends JpaRepository<CollectingProduct, Integer> {
    List<CollectingProduct> findAllByUserInfoIdAndDate(int id, Date date);
    CollectingProduct findByUserInfoIdAndDateAndProductId(int userId, Date date,int productId);
}
