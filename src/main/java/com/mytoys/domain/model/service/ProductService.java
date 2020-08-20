package com.mytoys.domain.model.service;

import com.mytoys.domain.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProductReader productReader;

    public ProductService(ProductReader productReader) {
        this.productReader = productReader;
    }

    public List<Product> findAll() {
        return productReader.readAll();
    }

    public Product findById(Long id) {
        return productReader.findById(id);
    }
}
