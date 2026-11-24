package com.lld.solid.practice.ports;

import com.lld.solid.practice.model.PracticeOrder;
import com.lld.solid.practice.model.PracticePaymentReceipt;

import java.math.BigDecimal;

public interface PracticePaymentProcessor {
    // LSP: Every implementation must accept a valid order and amount,
    // then return a valid receipt without forcing callers to know the subtype.
    PracticePaymentReceipt pay(PracticeOrder order, BigDecimal amount);
}
