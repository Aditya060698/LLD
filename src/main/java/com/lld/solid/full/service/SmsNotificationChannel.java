package com.lld.solid.full.service;

import com.lld.solid.full.model.Customer;
import com.lld.solid.full.ports.NotificationChannel;

public class SmsNotificationChannel implements NotificationChannel {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("SMS sent to " + customer.getPhoneNumber() + ": " + message);
    }
}
