package com.lld.gof.behavioral.observer.solution;

import java.util.ArrayList;
import java.util.List;

public class ObserverSolution {
    public static void main(String[] args) {
        CoursePublisher publisher = new CoursePublisher();
        publisher.addSubscriber(course -> System.out.println("notified: " + course));
        publisher.publish("Design Patterns");
    }

    /*
     * Observer Pattern
     *
     * Intent:
     * Notify many subscribers when one subject changes.
     */
    interface Subscriber {
        void update(String courseName);
    }

    static final class CoursePublisher {
        private final List<Subscriber> subscribers = new ArrayList<>();

        void addSubscriber(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        void publish(String courseName) {
            subscribers.forEach(subscriber -> subscriber.update(courseName));
        }
    }
}
