package com.lld.solid.practice.service;

import com.lld.solid.practice.model.PracticeOrder;
import com.lld.solid.practice.model.PracticePaymentReceipt;
import com.lld.solid.practice.ports.PracticePaymentProcessor;

import java.math.BigDecimal;

public class PracticeCardPaymentProcessor implements PracticePaymentProcessor {
    @Override
    public PracticePaymentReceipt pay(PracticeOrder order, BigDecimal amount) {
        // TODO: LSP task
        // Validate inputs and return a valid receipt.
        // Do not return null.
        // Do not throw for card-specific reasons that break the common contract.
        return new PracticePaymentReceipt(order.getId(), amount, "TODO-CARD-REF");
    }
}
