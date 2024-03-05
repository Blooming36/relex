package com.javatechie.repository;

import com.javatechie.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByFirstName(String firstName);
    UserInfo findById(int id);
}
