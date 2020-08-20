package com.mytoys.domain.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Float price;
    private Float oldPrice;
    private Integer stock;
    private String brand;
}