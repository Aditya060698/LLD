package com.lld.gof.creational.singleton.practice;

public class SingletonPractice {
    public static void main(String[] args) {
        PracticeAppConfig first = PracticeAppConfig.getInstance();
        PracticeAppConfig second = PracticeAppConfig.getInstance();

        System.out.println(first.getAppName());
        System.out.println("Same object? " + (first == second));
    }

    /*
     * Singleton Practice
     *
     * Goal:
     * Make this class create only one object.
     *
     * You should learn:
     * 1. Why the constructor is private.
     * 2. Why the instance is static.
     * 3. Why callers use getInstance() instead of new.
     */
    static final class PracticeAppConfig {
        // TODO: Singleton task
        // Create one private static final instance of PracticeAppConfig.

        private PracticeAppConfig() {
            // TODO: Keep this private so outside code cannot create more objects.
        }

        static PracticeAppConfig getInstance() {
            // TODO: Return the single shared object.
            return new PracticeAppConfig();
        }

        String getAppName() {
            // TODO: Return a meaningful config value.
            return "TODO app name";
        }
    }
}
