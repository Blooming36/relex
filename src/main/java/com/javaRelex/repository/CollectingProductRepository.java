package com.javaRelex.repository;

import com.javaRelex.entity.CollectingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CollectingProductRepository extends JpaRepository<CollectingProduct, Integer> {
    List<CollectingProduct> findAllByUserInfoIdAndDate(int id, Date date);

    List<CollectingProduct> findAllByUserInfoId(int id);

    List<CollectingProduct> findAllByDate(Date date);

    CollectingProduct findByUserInfoIdAndDateAndProductId(int userId, Date date, int productId);

    @Query("SELECT cp FROM CollectingProduct cp WHERE cp.date BETWEEN :startDate AND :endDate")
    List<CollectingProduct> findCollectingProductsForDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
