package com.lld.oops.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private final String name;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    public Department(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = name;
    }

    public void addInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("instructor is required");
        }
        instructors.add(instructor);
    }

    public void addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("course is required");
        }
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(instructors);
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}
