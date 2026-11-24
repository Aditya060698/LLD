package com.lld.solid.practice.model;

public class PracticeCustomer {
    private final String id;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public PracticeCustomer(String id, String name, String email, String phoneNumber) {
        // TODO: Encapsulation support task
        // Validate all fields. Required text must not be null/blank.
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
