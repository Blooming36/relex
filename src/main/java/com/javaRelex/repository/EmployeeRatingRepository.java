package com.javaRelex.repository;

import com.javaRelex.entity.EmployeeRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface EmployeeRatingRepository extends JpaRepository<EmployeeRating, Integer> {
    EmployeeRating findByUserInfoIdAndDate(int id, Date date);
}
