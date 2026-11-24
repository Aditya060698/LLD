package com.lld.gof.behavioral.iterator.solution;

import java.util.Iterator;
import java.util.List;

public class IteratorSolution {
    public static void main(String[] args) {
        CourseCollection courses = new CourseCollection(List.of("OOP", "SOLID"));
        Iterator<String> iterator = courses.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
     * Iterator Pattern
     *
     * Intent:
     * Traverse a collection without exposing its internal representation.
     */
    record CourseCollection(List<String> courses) {
        Iterator<String> iterator() {
            return courses.iterator();
        }
    }
}
