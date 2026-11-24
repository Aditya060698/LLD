package com.lld.oops.practice;

public class InstructorPractice extends PersonPractice {
    private final String expertise;

    public InstructorPractice(String id, String name, String expertise) {
        super(id, name);
        // TODO: Encapsulation task
        // Validate expertise before assigning it.
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    @Override
    public String role() {
        // TODO: Inheritance + polymorphism task
        // Return an instructor-specific role message.
        return "TODO";
    }
}
