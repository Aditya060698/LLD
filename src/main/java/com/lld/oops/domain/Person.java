package com.lld.oops.domain;

public abstract class Person {
    private final String id;
    private String name;

    protected Person(String id, String name) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id is required");
        }
        this.id = id;
        changeName(name);
    }

    public final String getId() {
        return id;
    }

    public final String getDisplayName() {
        return name;
    }

    public final void changeName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = newName.trim();
    }

    public abstract String role();
}
