package com.javaRelex.controller;

import com.javaRelex.service.EmployeeRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class EmployeeRatingController {

    @Autowired
    private EmployeeRatingService employeeRatingService;

    @PostMapping("/addRatingUser/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addRatingUser(@PathVariable("id") int id,
                                @RequestParam("rating") int rating) {
        return employeeRatingService.addRatingUser(id, rating);
    }

    @GetMapping("/checkRating/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String checkRatingUser(@PathVariable("id") int id) {
        return employeeRatingService.checkRating(id);
    }
}
