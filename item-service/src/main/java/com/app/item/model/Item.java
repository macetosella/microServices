package com.app.item.model;

public class Item {

    private Product product;
    private Integer quantity;
    private Double totalAmount;

    public Item() {
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        setTotalAmount();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount() {
        totalAmount = product.getPrice() * quantity.doubleValue();
    }
}
