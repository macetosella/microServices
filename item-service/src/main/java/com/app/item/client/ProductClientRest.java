package com.app.item.client;

import com.app.item.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8001")
public interface ProductClientRest {

    @GetMapping("/list")
    List<Product> list();

    @GetMapping("/getProduct/{id}")
    Product detail(@PathVariable Long id);
}
