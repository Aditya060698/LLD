package com.lld.solid.full.service;

import com.lld.solid.full.ports.DiscountPolicy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageDiscountPolicy implements DiscountPolicy {
    private final BigDecimal percentage;

    public PercentageDiscountPolicy(BigDecimal percentage) {
        if (percentage == null || percentage.compareTo(BigDecimal.ZERO) < 0
                || percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("percentage must be between 0 and 100");
        }
        this.percentage = percentage;
    }

    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        if (subtotal == null) {
            throw new IllegalArgumentException("subtotal is required");
        }
        BigDecimal discount = subtotal
                .multiply(percentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return subtotal.subtract(discount);
    }

    @Override
    public String description() {
        return percentage + "% discount";
    }
}
