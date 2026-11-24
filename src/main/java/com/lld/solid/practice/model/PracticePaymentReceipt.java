package com.lld.solid.practice.model;

import java.math.BigDecimal;

public class PracticePaymentReceipt {
    private final String orderId;
    private final BigDecimal amount;
    private final String providerReference;

    public PracticePaymentReceipt(String orderId, BigDecimal amount, String providerReference) {
        // TODO: LSP support task
        // Every payment processor should create a valid receipt.
        // Validate orderId, amount, and providerReference here.
        this.orderId = orderId;
        this.amount = amount;
        this.providerReference = providerReference;
    }

    public String message() {
        // TODO: DRY task
        // Keep the payment message format in one place.
        return "TODO payment message";
    }
}
