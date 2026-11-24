package com.lld.solid.full.model;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public Customer(String id, String name, String email, String phoneNumber) {
        this.id = requireText(id, "id");
        this.name = requireText(name, "name");
        this.email = requireText(email, "email");
        this.phoneNumber = requireText(phoneNumber, "phone number");
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
        return value.trim();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
