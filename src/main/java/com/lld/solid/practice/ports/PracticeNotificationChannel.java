package com.lld.solid.practice.ports;

import com.lld.solid.practice.model.PracticeCustomer;

public interface PracticeNotificationChannel {
    // ISP: This interface only sends a notification.
    void send(PracticeCustomer customer, String message);
}
