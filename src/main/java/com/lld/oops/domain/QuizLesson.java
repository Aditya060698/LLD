package com.lld.oops.domain;

public class QuizLesson implements Lesson {
    private final String title;
    private final int questionCount;

    public QuizLesson(String title, int questionCount) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        if (questionCount <= 0) {
            throw new IllegalArgumentException("question count must be positive");
        }
        this.title = title;
        this.questionCount = questionCount;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String summary() {
        return "Quiz: " + title + " (" + questionCount + " questions)";
    }

    @Override
    public void deliver() {
        System.out.println("Starting quiz lesson: " + title);
    }
}
