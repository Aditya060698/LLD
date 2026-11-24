package com.lld.solid.full.ports;

import com.lld.solid.full.model.Order;

import java.math.BigDecimal;

public interface InvoiceFormatter {
    String format(Order order, BigDecimal subtotal, BigDecimal payableAmount);
}
