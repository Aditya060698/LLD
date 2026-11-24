package com.lld.solid.full.model;

import java.math.BigDecimal;

public class PaymentReceipt {
    private final String orderId;
    private final BigDecimal amount;
    private final String providerReference;

    public PaymentReceipt(String orderId, BigDecimal amount, String providerReference) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("order id is required");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        if (providerReference == null || providerReference.isBlank()) {
            throw new IllegalArgumentException("provider reference is required");
        }
        this.orderId = orderId;
        this.amount = amount;
        this.providerReference = providerReference;
    }

    public String message() {
        return "Payment successful for order " + orderId + ", amount " + amount
                + ", reference " + providerReference;
    }
}
