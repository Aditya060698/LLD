package com.lld.oops.practice;

public class VideoLessonPractice implements LessonPractice {
    private final String title;
    private final int durationInMinutes;

    public VideoLessonPractice(String title, int durationInMinutes) {
        // TODO: Encapsulation task
        // Validate title and duration before assigning.
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String summary() {
        // TODO: Polymorphism task
        // Return a video-specific summary.
        return "TODO";
    }

    @Override
    public void deliver() {
        // TODO: Polymorphism task
        // Print a video-specific delivery message.
        System.out.println("TODO");
    }
}
