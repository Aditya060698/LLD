package com.lld.solid.practice.model;

import java.math.BigDecimal;

public class PracticeOrderItem {
    private final String name;
    private final BigDecimal unitPrice;
    private final int quantity;

    public PracticeOrderItem(String name, BigDecimal unitPrice, int quantity) {
        // TODO: Encapsulation support task
        // Validate name, unitPrice, and quantity.
        // unitPrice and quantity must be positive.
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BigDecimal lineTotal() {
        // TODO: DRY task
        // Keep line total logic here so no other class repeats this formula.
        return BigDecimal.ZERO;
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
