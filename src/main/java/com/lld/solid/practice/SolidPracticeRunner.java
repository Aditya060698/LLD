package com.lld.solid.practice;

import com.lld.solid.practice.application.PracticeCheckoutService;
import com.lld.solid.practice.application.PracticeOrderTotalCalculator;
import com.lld.solid.practice.model.PracticeCustomer;
import com.lld.solid.practice.model.PracticeOrder;
import com.lld.solid.practice.model.PracticeOrderItem;
import com.lld.solid.practice.model.PracticePaymentReceipt;
import com.lld.solid.practice.ports.PracticeDiscountPolicy;
import com.lld.solid.practice.ports.PracticeNotificationChannel;
import com.lld.solid.practice.ports.PracticePaymentProcessor;
import com.lld.solid.practice.service.PracticeCardPaymentProcessor;
import com.lld.solid.practice.service.PracticeEmailNotificationChannel;
import com.lld.solid.practice.service.PracticePercentageDiscountPolicy;
import com.lld.solid.practice.service.PracticeSimpleInvoiceFormatter;

import java.math.BigDecimal;
import java.util.List;

public class SolidPracticeRunner {
    public static void main(String[] args) {
        PracticeCustomer customer = new PracticeCustomer(
                "C-201",
                "Ananya",
                "ananya@example.com",
                "+91-9888888888"
        );

        PracticeOrder order = new PracticeOrder("O-901", customer);
        order.addItem(new PracticeOrderItem("OOP Workbook", new BigDecimal("799.00"), 1));
        order.addItem(new PracticeOrderItem("SOLID Workbook", new BigDecimal("899.00"), 1));

        PracticeDiscountPolicy discountPolicy = new PracticePercentageDiscountPolicy(new BigDecimal("10"));
        PracticePaymentProcessor paymentProcessor = new PracticeCardPaymentProcessor();
        List<PracticeNotificationChannel> channels = List.of(new PracticeEmailNotificationChannel());

        PracticeCheckoutService checkoutService = new PracticeCheckoutService(
                new PracticeOrderTotalCalculator(),
                discountPolicy,
                paymentProcessor,
                channels,
                new PracticeSimpleInvoiceFormatter()
        );

        PracticePaymentReceipt receipt = checkoutService.checkout(order);
        System.out.println(receipt.message());
    }
}
