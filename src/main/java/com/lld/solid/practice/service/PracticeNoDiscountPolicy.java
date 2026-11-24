package com.lld.solid.practice.service;

import com.lld.solid.practice.ports.PracticeDiscountPolicy;

import java.math.BigDecimal;

public class PracticeNoDiscountPolicy implements PracticeDiscountPolicy {
    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        // TODO: OCP task
        // Return subtotal unchanged after validation.
        return subtotal;
    }

    @Override
    public String description() {
        return "No discount";
    }
}
