package com.lld.oops.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student extends Person {
    private final List<String> enrolledCourseCodes = new ArrayList<>();

    public Student(String id, String name) {
        super(id, name);
    }

    void addEnrollment(String courseCode) {
        if (!enrolledCourseCodes.contains(courseCode)) {
            enrolledCourseCodes.add(courseCode);
        }
    }

    public List<String> getEnrolledCourseCodes() {
        return Collections.unmodifiableList(enrolledCourseCodes);
    }

    @Override
    public String role() {
        return "Student learning " + enrolledCourseCodes.size() + " course(s)";
    }
}
