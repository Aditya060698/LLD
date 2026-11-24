package com.lld.gof.structural.flyweight.solution;

import java.util.HashMap;
import java.util.Map;

public class FlyweightSolution {
    public static void main(String[] args) {
        Icon first = IconFactory.get("course");
        Icon second = IconFactory.get("course");

        System.out.println(first);
        System.out.println("Same shared icon? " + (first == second));
    }

    /*
     * Flyweight Pattern
     *
     * Intent:
     * Share reusable objects to reduce memory usage.
     *
     * Here:
     * Icon type is intrinsic shared state.
     */
    record Icon(String type) {
    }

    static final class IconFactory {
        private static final Map<String, Icon> CACHE = new HashMap<>();

        static Icon get(String type) {
            return CACHE.computeIfAbsent(type, Icon::new);
        }
    }
}
