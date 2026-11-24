package com.lld.solid.practice.ports;

import java.math.BigDecimal;

public interface PracticeDiscountPolicy {
    // OCP: Add a new discount by creating another implementation,
    // not by editing PracticeCheckoutService.
    BigDecimal apply(BigDecimal subtotal);

    String description();
}
