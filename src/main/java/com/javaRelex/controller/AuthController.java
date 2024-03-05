package com.javaRelex.controller;

import com.javaRelex.dto.AuthRequest;
import com.javaRelex.entity.UserInfo;
import com.javaRelex.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/addNewUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return userInfoService.authenticateAndGetToken(authRequest);
    }

    @PostMapping("/blockUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String blockUser(@PathVariable("id") int id) {
        userInfoService.blockById(id);
        return "Пользователь заблокирован id = " + id;
    }
}
