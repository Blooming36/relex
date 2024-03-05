package com.javaRelex.service;

import com.javaRelex.dto.CollectingProductStatisticDto;
import com.javaRelex.entity.CollectingProduct;
import com.javaRelex.mapper.CollectingProductStatisticMapper;
import com.javaRelex.repository.CollectingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticService {
    @Autowired
    private CollectingProductRepository collectingProductRepository;
    @Autowired
    private CollectingProductStatisticMapper collectingProductStatisticMapper;
    public List<CollectingProductStatisticDto> getCollectingProducts(String period, Integer userId) {
        List<CollectingProductStatisticDto> collectingProductStatisticDtos = new ArrayList<>();
        if (period != null) {
            switch (period) {
                case "day":
                    collectingProductStatisticDtos=conertList(collectingProductRepository.findAllByDate(new Date()));
                    break;
                case "week":
                    collectingProductStatisticDtos=conertList(collectingProductRepository.findCollectingProductsForDate(
                            getStartOfWeek(new Date()),getEndOfWeek(new Date())
                    ));
                    break;
                case "month":
                    collectingProductStatisticDtos=conertList(collectingProductRepository.findCollectingProductsForDate(
                            getStartOfMonth(new Date()),getEndOfMonth(new Date())
                    ));
                    break;
            }
        }
        if (userId != null) {
            collectingProductStatisticDtos = conertList(collectingProductRepository.findAllByUserInfoId(userId));
        }
        if (collectingProductStatisticDtos == null){
            collectingProductStatisticDtos = conertList(collectingProductRepository.findAll());
        }
        return collectingProductStatisticDtos;
    }
    public List<CollectingProductStatisticDto> conertList(List<CollectingProduct> collectingProducts){
        return collectingProducts.stream().map(el->collectingProductStatisticMapper.toDTO(el))
                .collect(Collectors.toList());
    }
    public static Date getStartOfWeek(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startOfWeek = localDate.minusDays(localDate.getDayOfWeek().getValue() - 1);
        return Date.from(startOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfWeek(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endOfWeek = localDate.plusDays(7 - localDate.getDayOfWeek().getValue());
        return Date.from(endOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartOfMonth(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startOfMonth = localDate.withDayOfMonth(1);
        return Date.from(startOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfMonth(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endOfMonth = localDate.withDayOfMonth(localDate.lengthOfMonth());
        return Date.from(endOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
