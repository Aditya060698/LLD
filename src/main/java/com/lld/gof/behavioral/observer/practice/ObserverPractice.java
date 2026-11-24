package com.lld.gof.behavioral.observer.practice;

import java.util.ArrayList;
import java.util.List;

public class ObserverPractice {
    public static void main(String[] args) {
        PracticeCoursePublisher publisher = new PracticeCoursePublisher();
        publisher.addSubscriber(course -> System.out.println("notified: " + course));
        publisher.publish("Design Patterns");
    }

    /*
     * Observer Practice
     *
     * Goal:
     * Publisher should not know concrete subscriber classes.
     */
    interface PracticeSubscriber {
        void update(String courseName);
    }

    static final class PracticeCoursePublisher {
        private final List<PracticeSubscriber> subscribers = new ArrayList<>();

        void addSubscriber(PracticeSubscriber subscriber) {
            subscribers.add(subscriber);
        }

        void publish(String courseName) {
            // TODO: Observer task
            // Notify every subscriber.
        }
    }
}
