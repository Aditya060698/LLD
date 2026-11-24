package com.lld.oops.practice;

public abstract class PersonPractice {
    private final String id;
    private String name;

    protected PersonPractice(String id, String name) {
        // TODO: Encapsulation task 1
        // Validate id and name before assigning them.
        // id must not be null/blank.
        // name must not be null/blank.
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        // TODO: Encapsulation task 2
        // Validate newName before changing the private field.
        // Store the trimmed name.
        this.name = newName;
    }

    public abstract String role();
}
