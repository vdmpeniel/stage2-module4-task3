package com.mjc.stage2.impl;


import com.mjc.stage2.FilteringStrategy;
import com.mjc.stage2.Product;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MaxPriceFilteringStrategy implements FilteringStrategy {
    private double maxPrice;


    private double calculateMaxPrice(List<Product> productList){
        return productList.stream()
                .map(product -> product.getPrice())
                .max(Double::compare)
                .orElse(null);
    }

    @Override
    public boolean filter(Product product) {
        return product.getPrice() == maxPrice;
    }
}
