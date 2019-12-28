package com.app.product.controller;

import com.app.product.model.entity.Product;
import com.app.product.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> list(){
        return (List<Product>) productService.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product detail(@PathVariable Long id){
        return productService.findById(id);
    }
}
