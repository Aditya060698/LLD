package com.lld.solid.full.ports;

import com.lld.solid.full.model.Customer;

public interface NotificationChannel {
    void send(Customer customer, String message);
}
