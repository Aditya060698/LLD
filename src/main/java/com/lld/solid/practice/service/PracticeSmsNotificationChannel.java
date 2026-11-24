package com.lld.solid.practice.service;

import com.lld.solid.practice.model.PracticeCustomer;
import com.lld.solid.practice.ports.PracticeNotificationChannel;

public class PracticeSmsNotificationChannel implements PracticeNotificationChannel {
    @Override
    public void send(PracticeCustomer customer, String message) {
        // TODO: OCP + ISP task
        // This is a new notification type.
        // You should be able to use it without changing PracticeCheckoutService.
        System.out.println("TODO SMS notification");
    }
}
