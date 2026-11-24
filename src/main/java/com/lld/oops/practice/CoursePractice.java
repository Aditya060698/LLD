package com.lld.oops.practice;

import java.util.ArrayList;
import java.util.List;

public class CoursePractice {
    private final String code;
    private final String title;
    private final int capacity;
    private final List<StudentPractice> enrolledStudents = new ArrayList<>();

    public CoursePractice(String code, String title, int capacity) {
        // TODO: Encapsulation task
        // Validate code, title, and capacity.
        // capacity must be greater than 0.
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    public void enroll(StudentPractice student) {
        // TODO: Encapsulation + association task
        // Validate student.
        // Do not enroll beyond capacity.
        // Do not enroll same student twice.
        // If enrollment succeeds, update the student with this course code.
        enrolledStudents.add(student);
        student.addEnrollment(code);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public List<StudentPractice> getEnrolledStudents() {
        // TODO: Encapsulation task
        // Return an unmodifiable list or defensive copy.
        return enrolledStudents;
    }
}
