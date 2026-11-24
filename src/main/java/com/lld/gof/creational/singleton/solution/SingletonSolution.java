package com.lld.gof.creational.singleton.solution;

public class SingletonSolution {
    public static void main(String[] args) {
        AppConfig first = AppConfig.getInstance();
        AppConfig second = AppConfig.getInstance();

        System.out.println(first.getAppName());
        System.out.println("Same object? " + (first == second));
    }

    /*
     * Singleton Pattern
     *
     * Intent:
     * Ensure a class has exactly one object and provide a global access point to it.
     *
     * Where it is useful:
     * Shared configuration, logger, metrics registry, connection pool manager.
     *
     * Interview caution:
     * Singleton is easy to overuse. Prefer dependency injection when possible.
     */
    static final class AppConfig {
        private static final AppConfig INSTANCE = new AppConfig();
        private final String appName = "LLD Mastery";

        private AppConfig() {
        }

        static AppConfig getInstance() {
            return INSTANCE;
        }

        String getAppName() {
            return appName;
        }
    }
}
