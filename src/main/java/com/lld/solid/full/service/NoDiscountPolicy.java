package com.lld.solid.full.service;

import com.lld.solid.full.ports.DiscountPolicy;

import java.math.BigDecimal;

public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        if (subtotal == null) {
            throw new IllegalArgumentException("subtotal is required");
        }
        return subtotal;
    }

    @Override
    public String description() {
        return "No discount";
    }
}
