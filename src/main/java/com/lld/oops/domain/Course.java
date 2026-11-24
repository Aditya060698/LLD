package com.lld.oops.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {
    private final String code;
    private final String title;
    private final Instructor instructor;
    private final int capacity;
    private final List<Student> enrolledStudents = new ArrayList<>();
    private final List<CourseModule> modules = new ArrayList<>();

    public Course(String code, String title, Instructor instructor, int capacity) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code is required");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        if (instructor == null) {
            throw new IllegalArgumentException("instructor is required");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }

        this.code = code;
        this.title = title;
        this.instructor = instructor;
        this.capacity = capacity;
    }

    public void enroll(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student is required");
        }
        if (enrolledStudents.size() == capacity) {
            throw new IllegalStateException("course is full");
        }
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addEnrollment(code);
        }
    }

    public void addModule(CourseModule module) {
        if (module == null) {
            throw new IllegalArgumentException("module is required");
        }
        modules.add(module);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Student> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    public List<CourseModule> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        for (CourseModule module : modules) {
            lessons.addAll(module.getLessons());
        }
        return Collections.unmodifiableList(lessons);
    }
}
