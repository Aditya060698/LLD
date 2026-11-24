package com.lld.solid.practice.service;

import com.lld.solid.practice.ports.PracticeDiscountPolicy;

import java.math.BigDecimal;

public class PracticePercentageDiscountPolicy implements PracticeDiscountPolicy {
    private final BigDecimal percentage;

    public PracticePercentageDiscountPolicy(BigDecimal percentage) {
        // TODO: OCP + encapsulation task
        // Validate percentage between 0 and 100.
        this.percentage = percentage;
    }

    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        // TODO: OCP task
        // Apply this discount without changing PracticeCheckoutService.
        return subtotal;
    }

    @Override
    public String description() {
        return percentage + "% discount";
    }
}
