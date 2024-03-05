package com.javaRelex.repository;

import com.javaRelex.entity.CollectingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CollectingProductRepository extends JpaRepository<CollectingProduct, Integer> {
    List<CollectingProduct> findAllByUserInfoIdAndDate(int id, Date date);

    CollectingProduct findByUserInfoIdAndDateAndProductId(int userId, Date date, int productId);
}
