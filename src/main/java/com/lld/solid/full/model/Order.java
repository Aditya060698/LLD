package com.lld.solid.full.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final String id;
    private final Customer customer;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(String id, Customer customer) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id is required");
        }
        if (customer == null) {
            throw new IllegalArgumentException("customer is required");
        }
        this.id = id.trim();
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("item is required");
        }
        items.add(item);
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
