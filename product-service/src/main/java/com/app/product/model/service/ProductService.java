package com.app.product.model.service;

import com.app.product.model.entity.Product;

public interface ProductService {

    Iterable<Product> findAll();

    Product findById(Long id);
}
