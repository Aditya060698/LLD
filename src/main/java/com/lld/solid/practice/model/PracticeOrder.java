package com.lld.solid.practice.model;

import java.util.ArrayList;
import java.util.List;

public class PracticeOrder {
    private final String id;
    private final PracticeCustomer customer;
    private final List<PracticeOrderItem> items = new ArrayList<>();

    public PracticeOrder(String id, PracticeCustomer customer) {
        // TODO: Encapsulation support task
        // Validate id and customer.
        this.id = id;
        this.customer = customer;
    }

    public void addItem(PracticeOrderItem item) {
        // TODO: SRP task
        // Order should manage its own item list safely.
        // Validate item and then add it.
        items.add(item);
    }

    public String getId() {
        return id;
    }

    public PracticeCustomer getCustomer() {
        return customer;
    }

    public List<PracticeOrderItem> getItems() {
        // TODO: Encapsulation support task
        // Return an unmodifiable list or defensive copy.
        return items;
    }
}
