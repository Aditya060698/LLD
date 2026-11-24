package com.lld.gof.creational.solution;

import java.util.HashMap;
import java.util.Map;

public class CreationalSolutionDemo {
    public static void main(String[] args) {
        System.out.println("Singleton: " + AppConfig.getInstance().get("app"));
        System.out.println("Factory Method: " + new EmailNotificationFactory().create().send("Welcome"));
        System.out.println("Abstract Factory: " + new DarkThemeFactory().button().render());
        System.out.println("Builder: " + Report.builder().title("LLD").body("GoF patterns").build().print());
        System.out.println("Prototype: " + new CourseTemplate("LLD", "draft").copyWithStatus("published"));
    }

    static final class AppConfig {
        private static final AppConfig INSTANCE = new AppConfig();
        private final Map<String, String> values = new HashMap<>();

        private AppConfig() {
            values.put("app", "LLD Mastery");
        }

        static AppConfig getInstance() {
            return INSTANCE;
        }

        String get(String key) {
            return values.get(key);
        }
    }

    interface Notification {
        String send(String message);
    }

    static final class EmailNotification implements Notification {
        public String send(String message) {
            return "Email sent: " + message;
        }
    }

    abstract static class NotificationFactory {
        abstract Notification create();
    }

    static final class EmailNotificationFactory extends NotificationFactory {
        Notification create() {
            return new EmailNotification();
        }
    }

    interface Button {
        String render();
    }

    interface ThemeFactory {
        Button button();
    }

    static final class DarkButton implements Button {
        public String render() {
            return "Dark button";
        }
    }

    static final class DarkThemeFactory implements ThemeFactory {
        public Button button() {
            return new DarkButton();
        }
    }

    static final class Report {
        private final String title;
        private final String body;

        private Report(Builder builder) {
            this.title = builder.title;
            this.body = builder.body;
        }

        static Builder builder() {
            return new Builder();
        }

        String print() {
            return title + ": " + body;
        }

        static final class Builder {
            private String title;
            private String body;

            Builder title(String title) {
                this.title = title;
                return this;
            }

            Builder body(String body) {
                this.body = body;
                return this;
            }

            Report build() {
                if (title == null || title.isBlank() || body == null || body.isBlank()) {
                    throw new IllegalStateException("title and body are required");
                }
                return new Report(this);
            }
        }
    }

    record CourseTemplate(String name, String status) {
        CourseTemplate copyWithStatus(String newStatus) {
            return new CourseTemplate(name, newStatus);
        }
    }
}
