package com.javatechie.controller;

import com.javatechie.entity.EmployeeRating;
import com.javatechie.entity.Product;
import com.javatechie.service.EmployeeRatingService;
import com.javatechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/rating")
public class EmployeeRatingController {

    @Autowired
    private EmployeeRatingService employeeRatingService;

    @PostMapping("/addRatingUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addRatingUser(@PathVariable("id") int id,
                                @RequestParam("rating") int rating){
        return employeeRatingService.addRatingUser(id,rating);
    }
    @GetMapping("/checkRating/{id}")
    public String checkRatingUser(@PathVariable("id") int id){
        return employeeRatingService.checkRating(id);
    }
}
