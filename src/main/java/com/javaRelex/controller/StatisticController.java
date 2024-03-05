package com.javaRelex.controller;

import com.javaRelex.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
    @GetMapping("/collecting-products")
    public List<?> getCollectingProducts(@RequestParam(required = false) String period,
                                         @RequestParam(required = false) Integer userId) {
        return statisticService.getCollectingProducts(period,userId);
    }
}
