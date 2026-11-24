package com.lld.gof.behavioral.iterator.practice;

import java.util.Iterator;
import java.util.List;

public class IteratorPractice {
    public static void main(String[] args) {
        PracticeCourseCollection courses = new PracticeCourseCollection(List.of("OOP", "SOLID"));
        Iterator<String> iterator = courses.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
     * Iterator Practice
     *
     * Goal:
     * Let callers traverse without knowing how courses are stored.
     */
    record PracticeCourseCollection(List<String> courses) {
        Iterator<String> iterator() {
            // TODO: Iterator task
            // Return courses.iterator().
            return courses.iterator();
        }
    }
}
