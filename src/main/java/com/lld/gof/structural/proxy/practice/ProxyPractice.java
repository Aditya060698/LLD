package com.lld.gof.structural.proxy.practice;

import java.util.HashMap;
import java.util.Map;

public class ProxyPractice {
    public static void main(String[] args) {
        PracticeCourseRepository repository = new PracticeCachedCourseRepository(new PracticeRealCourseRepository());
        System.out.println(repository.findById("C-1"));
        System.out.println(repository.findById("C-1"));
    }

    /*
     * Proxy Practice
     *
     * Goal:
     * Add caching without changing the repository interface.
     */
    interface PracticeCourseRepository {
        String findById(String id);
    }

    static final class PracticeRealCourseRepository implements PracticeCourseRepository {
        public String findById(String id) {
            return "Course " + id;
        }
    }

    static final class PracticeCachedCourseRepository implements PracticeCourseRepository {
        private final PracticeCourseRepository realRepository;
        private final Map<String, String> cache = new HashMap<>();

        PracticeCachedCourseRepository(PracticeCourseRepository realRepository) {
            this.realRepository = realRepository;
        }

        public String findById(String id) {
            // TODO: Proxy task
            // Return cached value if present, otherwise call realRepository and cache it.
            return realRepository.findById(id);
        }
    }
}
