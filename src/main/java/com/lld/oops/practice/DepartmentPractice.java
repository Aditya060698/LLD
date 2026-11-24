package com.lld.oops.practice;

import java.util.ArrayList;
import java.util.List;

public class DepartmentPractice {
    private final String name;
    private final List<InstructorPractice> instructors = new ArrayList<>();
    private final List<CoursePractice> courses = new ArrayList<>();

    public DepartmentPractice(String name) {
        // TODO: Encapsulation task
        // Validate department name.
        this.name = name;
    }

    public void addInstructor(InstructorPractice instructor) {
        // TODO: Aggregation task
        // A department groups instructors, but does not own their lifecycle.
        // Validate and add the instructor.
        instructors.add(instructor);
    }

    public void addCourse(CoursePractice course) {
        // TODO: Aggregation task
        // A department groups courses, but courses can exist independently.
        // Validate and add the course.
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public List<InstructorPractice> getInstructors() {
        // TODO: Encapsulation task
        // Return an unmodifiable list or defensive copy.
        return instructors;
    }

    public List<CoursePractice> getCourses() {
        // TODO: Encapsulation task
        // Return an unmodifiable list or defensive copy.
        return courses;
    }
}
