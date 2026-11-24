package com.lld.solid.practice.service;

import com.lld.solid.practice.model.PracticeOrder;
import com.lld.solid.practice.model.PracticePaymentReceipt;
import com.lld.solid.practice.ports.PracticePaymentProcessor;

import java.math.BigDecimal;

public class PracticeUpiPaymentProcessor implements PracticePaymentProcessor {
    @Override
    public PracticePaymentReceipt pay(PracticeOrder order, BigDecimal amount) {
        // TODO: LSP task
        // This should be substitutable for PracticeCardPaymentProcessor.
        // PracticeCheckoutService should not need an if condition for UPI.
        return new PracticePaymentReceipt(order.getId(), amount, "TODO-UPI-REF");
    }
}
