package com.lld.solid.full.model;

import java.math.BigDecimal;

public class OrderItem {
    private final String name;
    private final BigDecimal unitPrice;
    private final int quantity;

    public OrderItem(String name, BigDecimal unitPrice, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("unit price must be positive");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        this.name = name.trim();
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BigDecimal lineTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
