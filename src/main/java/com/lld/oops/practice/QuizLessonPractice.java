package com.lld.oops.practice;

public class QuizLessonPractice implements LessonPractice {
    private final String title;
    private final int questionCount;

    public QuizLessonPractice(String title, int questionCount) {
        // TODO: Encapsulation task
        // Validate title and question count before assigning.
        this.title = title;
        this.questionCount = questionCount;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String summary() {
        // TODO: Polymorphism task
        // Return a quiz-specific summary.
        return "TODO";
    }

    @Override
    public void deliver() {
        // TODO: Polymorphism task
        // Print a quiz-specific delivery message.
        System.out.println("TODO");
    }
}
