package com.lld.solid.full.application;

import com.lld.solid.full.model.Order;
import com.lld.solid.full.model.PaymentReceipt;
import com.lld.solid.full.ports.DiscountPolicy;
import com.lld.solid.full.ports.InvoiceFormatter;
import com.lld.solid.full.ports.NotificationChannel;
import com.lld.solid.full.ports.PaymentProcessor;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutService {
    private final OrderTotalCalculator totalCalculator;
    private final DiscountPolicy discountPolicy;
    private final PaymentProcessor paymentProcessor;
    private final List<NotificationChannel> notificationChannels;
    private final InvoiceFormatter invoiceFormatter;

    public CheckoutService(
            OrderTotalCalculator totalCalculator,
            DiscountPolicy discountPolicy,
            PaymentProcessor paymentProcessor,
            List<NotificationChannel> notificationChannels,
            InvoiceFormatter invoiceFormatter
    ) {
        if (totalCalculator == null || discountPolicy == null || paymentProcessor == null
                || notificationChannels == null || invoiceFormatter == null) {
            throw new IllegalArgumentException("checkout dependencies are required");
        }
        this.totalCalculator = totalCalculator;
        this.discountPolicy = discountPolicy;
        this.paymentProcessor = paymentProcessor;
        this.notificationChannels = List.copyOf(notificationChannels);
        this.invoiceFormatter = invoiceFormatter;
    }

    public PaymentReceipt checkout(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order is required");
        }

        BigDecimal subtotal = totalCalculator.calculateSubtotal(order);
        BigDecimal payableAmount = discountPolicy.apply(subtotal);
        PaymentReceipt receipt = paymentProcessor.pay(order, payableAmount);
        String invoice = invoiceFormatter.format(order, subtotal, payableAmount);

        for (NotificationChannel channel : notificationChannels) {
            channel.send(order.getCustomer(), invoice);
        }

        return receipt;
    }
}
