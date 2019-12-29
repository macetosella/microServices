package com.app.item.controller;

import com.app.item.model.Item;
import com.app.item.model.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public List<Item> list(){
        return itemService.findAll();
    }

    @GetMapping("/getItem/{id}/{quantity}")
    public Item detail(@PathVariable  Long id, @PathVariable Integer quantity){
        return itemService.findById(id, quantity);
    }
}
