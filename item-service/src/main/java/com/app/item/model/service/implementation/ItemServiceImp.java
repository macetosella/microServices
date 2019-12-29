package com.app.item.model.service.implementation;

import com.app.item.model.Item;
import com.app.item.model.Product;
import com.app.item.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImp implements ItemService {

    private RestTemplate restClient;

    @Autowired
    public ItemServiceImp(RestTemplate restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(restClient.getForObject("http://localhost:8001/list", Product[].class));
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> variablePath = new HashMap<>();
        variablePath.put("id", id.toString());
        Product product = restClient.getForObject("http://localhost:8001/getProduct/{id}", Product.class, variablePath);
        return new Item(product, quantity);
    }
}