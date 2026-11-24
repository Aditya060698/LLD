package com.lld.oops.practice;

import java.util.ArrayList;
import java.util.List;

public class StudentPractice extends PersonPractice {
    private final List<String> enrolledCourseCodes = new ArrayList<>();

    public StudentPractice(String id, String name) {
        super(id, name);
    }

    public void addEnrollment(String courseCode) {
        // TODO: Encapsulation task 3
        // Add the course code only if it is valid and not already present.
        enrolledCourseCodes.add(courseCode);
    }

    public List<String> getEnrolledCourseCodes() {
        // TODO: Encapsulation task 4
        // Do not expose the original mutable list.
        // Return an unmodifiable view or defensive copy.
        return enrolledCourseCodes;
    }

    @Override
    public String role() {
        // TODO: Inheritance + polymorphism task
        // Return a student-specific role message.
        return "TODO";
    }
}
