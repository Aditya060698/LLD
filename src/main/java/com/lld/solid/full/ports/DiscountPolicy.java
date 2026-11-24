package com.lld.solid.full.ports;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal apply(BigDecimal subtotal);

    String description();
}
