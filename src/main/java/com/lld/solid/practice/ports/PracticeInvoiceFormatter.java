package com.lld.solid.practice.ports;

import com.lld.solid.practice.model.PracticeOrder;

import java.math.BigDecimal;

public interface PracticeInvoiceFormatter {
    // ISP: This interface only formats invoices.
    // Do not add sendEmail(), processPayment(), or saveOrder() here.
    String format(PracticeOrder order, BigDecimal subtotal, BigDecimal payableAmount);
}
