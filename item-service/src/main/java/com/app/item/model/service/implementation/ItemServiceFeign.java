package com.app.item.model.service.implementation;

import com.app.item.client.ProductClientRest;
import com.app.item.model.Item;
import com.app.item.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ItemServiceFeign implements ItemService {

    private ProductClientRest productClientRest;

    @Autowired
    public ItemServiceFeign(ProductClientRest productClientRest) {
        this.productClientRest = productClientRest;
    }

    @Override
    public List<Item> findAll() {
        return productClientRest.list().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(productClientRest.detail(id), quantity);
    }
}
