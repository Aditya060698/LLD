package com.lld.solid.full.application;

import com.lld.solid.full.model.Order;
import com.lld.solid.full.model.OrderItem;

import java.math.BigDecimal;

public class OrderTotalCalculator {
    public BigDecimal calculateSubtotal(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order is required");
        }

        BigDecimal subtotal = BigDecimal.ZERO;
        for (OrderItem item : order.getItems()) {
            subtotal = subtotal.add(item.lineTotal());
        }
        return subtotal;
    }
}
