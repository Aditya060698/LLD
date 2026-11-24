package com.lld.solid.practice.service;

import com.lld.solid.practice.model.PracticeOrder;
import com.lld.solid.practice.ports.PracticeInvoiceFormatter;

import java.math.BigDecimal;

public class PracticeSimpleInvoiceFormatter implements PracticeInvoiceFormatter {
    @Override
    public String format(PracticeOrder order, BigDecimal subtotal, BigDecimal payableAmount) {
        // TODO: SRP + ISP task
        // Only format invoice text here.
        return "TODO invoice";
    }
}
