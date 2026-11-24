package com.lld.solid.full;

import com.lld.solid.full.application.CheckoutService;
import com.lld.solid.full.application.OrderTotalCalculator;
import com.lld.solid.full.model.Customer;
import com.lld.solid.full.model.Order;
import com.lld.solid.full.model.OrderItem;
import com.lld.solid.full.model.PaymentReceipt;
import com.lld.solid.full.ports.DiscountPolicy;
import com.lld.solid.full.ports.NotificationChannel;
import com.lld.solid.full.ports.PaymentProcessor;
import com.lld.solid.full.service.CardPaymentProcessor;
import com.lld.solid.full.service.EmailNotificationChannel;
import com.lld.solid.full.service.PercentageDiscountPolicy;
import com.lld.solid.full.service.SimpleInvoiceFormatter;
import com.lld.solid.full.service.SmsNotificationChannel;
import com.lld.solid.full.service.UpiPaymentProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SolidPrinciplesDemo {
    public static void main(String[] args) {
        Customer customer = new Customer("C-101", "Rahul", "rahul@example.com", "+91-9000000000");
        Order order = new Order("O-501", customer);
        order.addItem(new OrderItem("LLD Course", new BigDecimal("4999.00"), 1));
        order.addItem(new OrderItem("Design Patterns Workbook", new BigDecimal("999.00"), 1));

        DiscountPolicy discountPolicy = new PercentageDiscountPolicy(new BigDecimal("10"));
        PaymentProcessor paymentProcessor = new CardPaymentProcessor();
        List<NotificationChannel> notificationChannels = List.of(
                new EmailNotificationChannel(),
                new SmsNotificationChannel()
        );

        CheckoutService checkoutService = new CheckoutService(
                new OrderTotalCalculator(),
                discountPolicy,
                paymentProcessor,
                notificationChannels,
                new SimpleInvoiceFormatter()
        );

        PaymentReceipt receipt = checkoutService.checkout(order);
        System.out.println(receipt.message());

        PaymentProcessor upiProcessor = new UpiPaymentProcessor();
        CheckoutService upiCheckout = new CheckoutService(
                new OrderTotalCalculator(),
                discountPolicy,
                upiProcessor,
                notificationChannels,
                new SimpleInvoiceFormatter()
        );

        System.out.println(upiCheckout.checkout(order).message());
    }
}
