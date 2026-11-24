package com.lld.solid.full.ports;

import com.lld.solid.full.model.Order;
import com.lld.solid.full.model.PaymentReceipt;

import java.math.BigDecimal;

public interface PaymentProcessor {
    PaymentReceipt pay(Order order, BigDecimal amount);
}
