package com.lld.gof.structural.flyweight.practice;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPractice {
    public static void main(String[] args) {
        PracticeIcon first = PracticeIconFactory.get("course");
        PracticeIcon second = PracticeIconFactory.get("course");

        System.out.println(first);
        System.out.println("Same shared icon? " + (first == second));
    }

    /*
     * Flyweight Practice
     *
     * Goal:
     * Reuse one object for the same intrinsic state.
     */
    record PracticeIcon(String type) {
    }

    static final class PracticeIconFactory {
        private static final Map<String, PracticeIcon> CACHE = new HashMap<>();

        static PracticeIcon get(String type) {
            // TODO: Flyweight task
            // Return cached object when the same type is requested.
            return new PracticeIcon(type);
        }
    }
}
