package com.javatechie.repository;

import com.javatechie.entity.EmployeeRating;
import com.javatechie.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

public interface EmployeeRatingRepository extends JpaRepository<EmployeeRating, Integer> {
    EmployeeRating findByUserInfoIdAndDate(int id, Date date);
}
