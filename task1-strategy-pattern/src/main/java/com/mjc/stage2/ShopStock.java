package com.mjc.stage2;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;
import com.mjc.stage2.impl.MaxPriceFilteringStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ShopStock {
    private final List<Product> productList;

    public ShopStock(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy){
        return productList.stream()
            .filter(product -> filteringStrategy.filter(product))
            .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        List<Product> productList = List.of(
                Product.builder()
                        .manufacture("Apple")
                        .name("iphone")
                        .price(120)
                        .build(),
                Product.builder()
                        .manufacture("Apple")
                        .name("Mac Book")
                        .price(1800)
                        .build(),
                Product.builder()
                        .manufacture("Dell")
                        .name("alienware")
                        .price(1800)
                        .build(),
                Product.builder()
                        .manufacture("LENOVO")
                        .name("thinkpad")
                        .price(500)
                        .build()

        );
        ShopStock shopStock = new ShopStock(productList);
        System.out.println(shopStock.executeFilteringStrategy(new ManufactureFilteringStrategy("Apple")));
        System.out.println(shopStock.executeFilteringStrategy(new MaxPriceFilteringStrategy(1800)));
    }
}
