package com.lld.solid.full.service;

import com.lld.solid.full.model.Order;
import com.lld.solid.full.model.PaymentReceipt;
import com.lld.solid.full.ports.PaymentProcessor;

import java.math.BigDecimal;

public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentReceipt pay(Order order, BigDecimal amount) {
        if (order == null || amount == null) {
            throw new IllegalArgumentException("order and amount are required");
        }
        return new PaymentReceipt(order.getId(), amount, "CARD-" + order.getId());
    }
}
