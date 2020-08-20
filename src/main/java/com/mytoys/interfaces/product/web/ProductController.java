package com.mytoys.interfaces.product.web;

import com.mytoys.domain.model.product.Product;
import com.mytoys.domain.model.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    @ResponseBody
    List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }
}
