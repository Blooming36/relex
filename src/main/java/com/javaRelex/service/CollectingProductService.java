package com.javaRelex.service;

import com.javaRelex.dto.CollectingProductDto;
import com.javaRelex.entity.CollectingProduct;
import com.javaRelex.mapper.CollectingProductMapper;
import com.javaRelex.repository.CollectingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectingProductService {

    @Autowired
    private CollectingProductRepository collectingProductRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${sql.collectingProduct}")
    private String collectProduct;
    @Autowired
    private CollectingProductMapper collectingProductMapper;

    public String setNorm(int userId, int productId, int theRateOfCollection) throws IOException {
        String sql = new String(Files.readAllBytes(Paths.get(collectProduct)));
        jdbcTemplate.update(sql, userId, productId, theRateOfCollection, 0, new Date());
        return "Вы добавили дневную норму для пользователя " + userId;
    }

    public List<CollectingProductDto> getAllProductForUser(int id) {
        return collectingProductRepository.findAllByUserInfoIdAndDate(id, new Date()).stream()
                .map(el -> collectingProductMapper.toDTO(el))
                .collect(Collectors.toList());
    }

    public String collectingProduct(int userId, int productId, int collect) {
        CollectingProduct collectingProduct = collectingProductRepository
                .findByUserInfoIdAndDateAndProductId(userId, new Date(), productId);
        collectingProduct.setCollecting(collectingProduct.getCollecting() + collect);
        collectingProductRepository.save(collectingProduct);
        return calculation(collectingProduct.getTheRateOfCollection(),
                collectingProduct.getCollecting(),
                collectingProduct.getProduct().getUnitOfMeasurement());
    }

    public String calculation(int theRateOfCollection, int collecting, String unitOfMeasurement) {
        int diff = theRateOfCollection - collecting;
        String message = diff > 0 ? "Вам осталось собрать " + diff :
                diff < 0 ? "Вы собрали больше на " + Math.abs(diff) :
                        "Вы собрали нужное количество!";
        return message + " " + unitOfMeasurement;
    }
}
