package com.mytoys.domain.model.service;

import com.mytoys.domain.model.product.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ProductMother {

    public static List<Product> mockProducts() {

        return LongStream.range(0, 100).mapToObj(i ->
                new Product(i, "Name " + i, new Float(i), new Float(i - 1), Math.toIntExact(i), "barnd " + i))
                .collect(Collectors.toList());
    }
}
