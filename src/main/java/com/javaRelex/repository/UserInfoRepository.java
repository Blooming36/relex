package com.javaRelex.repository;

import com.javaRelex.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByFirstName(String firstName);

    UserInfo findById(int id);
}
