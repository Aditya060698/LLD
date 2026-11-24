package com.lld.solid.practice.service;

import com.lld.solid.practice.model.PracticeCustomer;
import com.lld.solid.practice.ports.PracticeNotificationChannel;

public class PracticeEmailNotificationChannel implements PracticeNotificationChannel {
    @Override
    public void send(PracticeCustomer customer, String message) {
        // TODO: ISP task
        // This class should only know how to send email.
        System.out.println("TODO email notification");
    }
}
