package com.lld.oops.practice;

public interface LessonPractice {
    // TODO: Abstraction task
    // This interface already defines what every lesson must do.
    // Implement this contract in VideoLessonPractice, QuizLessonPractice,
    // and your own AssignmentLessonPractice.
    String title();

    String summary();

    void deliver();
}
