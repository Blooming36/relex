package com.javaRelex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

    @GetMapping("/collecting-products")
    public List<?> getCollectingProducts(@RequestParam(required = false) String period,
                                         @RequestParam(required = false) Integer userId) {
        return null;
    }
}
