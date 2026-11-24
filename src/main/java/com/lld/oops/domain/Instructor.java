package com.lld.oops.domain;

public class Instructor extends Person {
    private final String expertise;

    public Instructor(String id, String name, String expertise) {
        super(id, name);
        if (expertise == null || expertise.isBlank()) {
            throw new IllegalArgumentException("expertise is required");
        }
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    @Override
    public String role() {
        return "Instructor teaching " + expertise;
    }
}
