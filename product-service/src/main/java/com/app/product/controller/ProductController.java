package com.app.product.controller;

import com.app.product.model.entity.Product;
import com.app.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private ProductService productService;
    private Environment environment;

    @Autowired
    public ProductController(ProductService productService, Environment environment) {
        this.productService = productService;
        this.environment = environment;
    }

    @GetMapping("/list")
    public List<Product> list() {
        return ((List<Product>) productService.findAll()).stream().map(
                p -> {
                    p.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
                    return p;
                }).collect(Collectors.toList());
    }

    @GetMapping("/getProduct/{id}")
    public Product detail(@PathVariable Long id) {
        Product product = productService.findById(id);
        product.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        return product;
    }
}
