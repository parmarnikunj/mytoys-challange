package com.mytoys.domain.model.service;

import com.mytoys.domain.model.product.Product;

import java.util.List;

public interface ProductReader {
    List<Product> readAll();

    Product findById(Long id);
}
