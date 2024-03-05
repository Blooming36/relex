package com.javaRelex.controller;

import com.javaRelex.dto.CollectingProductStatisticDto;
import com.javaRelex.service.EmailService;
import com.javaRelex.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private EmailService emailService;
    @Value("${mail.to}")
    private String to;
    @Value("${mail.subject}")
    private String subject;
    @GetMapping("/collecting-products")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public List<CollectingProductStatisticDto> getCollectingProducts(@RequestParam(required = false) String period,
                                                                     @RequestParam(required = false) Integer userId) {
        return statisticService.getCollectingProducts(period, userId);
    }

    @Scheduled(cron = "0 0 18 * * *")
    public void performDailyTask() {
        emailService.sendEmail(to, subject);
    }
}
