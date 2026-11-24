package com.lld.solid.practice.application;

import com.lld.solid.practice.model.PracticeOrder;
import com.lld.solid.practice.model.PracticePaymentReceipt;
import com.lld.solid.practice.ports.PracticeDiscountPolicy;
import com.lld.solid.practice.ports.PracticeInvoiceFormatter;
import com.lld.solid.practice.ports.PracticeNotificationChannel;
import com.lld.solid.practice.ports.PracticePaymentProcessor;

import java.math.BigDecimal;
import java.util.List;

public class PracticeCheckoutService {
    private final PracticeOrderTotalCalculator totalCalculator;
    private final PracticeDiscountPolicy discountPolicy;
    private final PracticePaymentProcessor paymentProcessor;
    private final List<PracticeNotificationChannel> notificationChannels;
    private final PracticeInvoiceFormatter invoiceFormatter;

    public PracticeCheckoutService(
            PracticeOrderTotalCalculator totalCalculator,
            PracticeDiscountPolicy discountPolicy,
            PracticePaymentProcessor paymentProcessor,
            List<PracticeNotificationChannel> notificationChannels,
            PracticeInvoiceFormatter invoiceFormatter
    ) {
        // TODO: DIP task
        // Validate all dependencies.
        // Store abstractions, not concrete implementations.
        // Copy the notification channel list so external code cannot mutate it.
        this.totalCalculator = totalCalculator;
        this.discountPolicy = discountPolicy;
        this.paymentProcessor = paymentProcessor;
        this.notificationChannels = notificationChannels;
        this.invoiceFormatter = invoiceFormatter;
    }

    public PracticePaymentReceipt checkout(PracticeOrder order) {
        // TODO: SRP + DIP task
        // This service should orchestrate the workflow only.
        // Do not manually calculate totals here.
        // Do not manually apply discount rules here.
        // Do not directly create a concrete payment processor here.
        // Do not directly send email/SMS here.

        BigDecimal subtotal = totalCalculator.calculateSubtotal(order);
        BigDecimal payableAmount = discountPolicy.apply(subtotal);
        PracticePaymentReceipt receipt = paymentProcessor.pay(order, payableAmount);
        String invoice = invoiceFormatter.format(order, subtotal, payableAmount);

        for (PracticeNotificationChannel channel : notificationChannels) {
            channel.send(order.getCustomer(), invoice);
        }

        return receipt;
    }
}
