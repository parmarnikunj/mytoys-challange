package com.mytoys.domain.model.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductService productService;

    @Test
    void testFindProducts() {

        given(productService.findAll()).willReturn(ProductMother.mockProducts());

        Assertions.assertThat(productService.findAll()).isNotEmpty();
        Assertions.assertThat(productService.findAll()).hasSize(100);
    }
}