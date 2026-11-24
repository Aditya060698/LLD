package com.lld.solid.full.service;

import com.lld.solid.full.model.Customer;
import com.lld.solid.full.ports.NotificationChannel;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("Email sent to " + customer.getEmail() + ": " + message);
    }
}
