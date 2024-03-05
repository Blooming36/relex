package com.javaRelex.controller;

import com.javaRelex.dto.CollectingProductDto;
import com.javaRelex.service.CollectingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/collecting")
public class CollectingProductController {
    @Autowired
    private CollectingProductService collectingProductService;

    @PostMapping("/setNormUser/{userId}/{productId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String setNorm(@PathVariable("userId") int userId,
                          @PathVariable("productId") int productId,
                          @RequestParam("theRateOfCollection") int theRateOfCollection) throws IOException {
        return collectingProductService.setNorm(userId, productId, theRateOfCollection);
    }

    @PostMapping("/collectingProduct/{userId}/{productId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public String collectingProduct(@PathVariable("userId") int userId,
                                    @PathVariable("productId") int productId,
                                    @RequestParam("collect") int collect) {
        return collectingProductService.collectingProduct(userId, productId, collect);
    }

    @GetMapping("/getAllProductForUser/{userId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public List<CollectingProductDto> getAllProductForUser(@PathVariable("userId") int userId) {
        return collectingProductService.getAllProductForUser(userId);
    }
}
