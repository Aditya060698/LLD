package com.lld.oops.domain;

public class VideoLesson implements Lesson {
    private final String title;
    private final int durationInMinutes;

    public VideoLesson(String title, int durationInMinutes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException("duration must be positive");
        }
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String summary() {
        return "Video: " + title + " (" + durationInMinutes + " mins)";
    }

    @Override
    public void deliver() {
        System.out.println("Playing video lesson: " + title);
    }
}
