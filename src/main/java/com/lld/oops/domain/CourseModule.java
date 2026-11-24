package com.lld.oops.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseModule {
    private final String title;
    private final List<Lesson> lessons = new ArrayList<>();

    public CourseModule(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        this.title = title;
    }

    public void addLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("lesson is required");
        }
        lessons.add(lesson);
    }

    public String getTitle() {
        return title;
    }

    public List<Lesson> getLessons() {
        return Collections.unmodifiableList(lessons);
    }
}
