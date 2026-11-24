package com.lld.solid.full.service;

import com.lld.solid.full.model.Order;
import com.lld.solid.full.ports.InvoiceFormatter;

import java.math.BigDecimal;

public class SimpleInvoiceFormatter implements InvoiceFormatter {
    @Override
    public String format(Order order, BigDecimal subtotal, BigDecimal payableAmount) {
        return "Invoice for " + order.getCustomer().getName()
                + " | order=" + order.getId()
                + " | subtotal=" + subtotal
                + " | payable=" + payableAmount;
    }
}
