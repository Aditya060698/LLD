package com.lld.gof.structural.proxy.solution;

import java.util.HashMap;
import java.util.Map;

public class ProxySolution {
    public static void main(String[] args) {
        CourseRepository repository = new CachedCourseRepository(new RealCourseRepository());
        System.out.println(repository.findById("C-1"));
        System.out.println(repository.findById("C-1"));
    }

    /*
     * Proxy Pattern
     *
     * Intent:
     * Control access to another object while preserving the same interface.
     *
     * Here:
     * Proxy adds caching before calling the real repository.
     */
    interface CourseRepository {
        String findById(String id);
    }

    static final class RealCourseRepository implements CourseRepository {
        public String findById(String id) {
            return "Course " + id;
        }
    }

    static final class CachedCourseRepository implements CourseRepository {
        private final CourseRepository realRepository;
        private final Map<String, String> cache = new HashMap<>();

        CachedCourseRepository(CourseRepository realRepository) {
            this.realRepository = realRepository;
        }

        public String findById(String id) {
            return cache.computeIfAbsent(id, realRepository::findById);
        }
    }
}
