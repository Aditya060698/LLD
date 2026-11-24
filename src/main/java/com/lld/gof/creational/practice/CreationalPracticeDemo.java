package com.lld.gof.creational.practice;

public class CreationalPracticeDemo {
    public static void main(String[] args) {
        System.out.println("Singleton: " + PracticeAppConfig.getInstance().get("app"));
        System.out.println("Factory Method: " + new PracticeEmailNotificationFactory().create().send("Welcome"));
        System.out.println("Abstract Factory: " + new PracticeDarkThemeFactory().button().render());
        System.out.println("Builder: " + PracticeReport.builder().title("LLD").body("GoF patterns").build().print());
        System.out.println("Prototype: " + new PracticeCourseTemplate("LLD", "draft").copyWithStatus("published"));
    }

    static final class PracticeAppConfig {
        // TODO: Singleton task
        // Make sure only one instance of this class can exist.
        // Keep constructor private and expose one global access method.
        private static final PracticeAppConfig INSTANCE = new PracticeAppConfig();

        private PracticeAppConfig() {
        }

        static PracticeAppConfig getInstance() {
            return INSTANCE;
        }

        String get(String key) {
            // TODO: Return a real config value based on key.
            return "TODO config";
        }
    }

    interface PracticeNotification {
        String send(String message);
    }

    static final class PracticeEmailNotification implements PracticeNotification {
        public String send(String message) {
            // TODO: Factory Method task
            // Return an email-specific message.
            return "TODO email";
        }
    }

    abstract static class PracticeNotificationFactory {
        // TODO: Factory Method task
        // Subclasses decide which concrete notification to create.
        abstract PracticeNotification create();
    }

    static final class PracticeEmailNotificationFactory extends PracticeNotificationFactory {
        PracticeNotification create() {
            return new PracticeEmailNotification();
        }
    }

    interface PracticeButton {
        String render();
    }

    interface PracticeThemeFactory {
        // TODO: Abstract Factory task
        // Add related UI components here only when needed.
        PracticeButton button();
    }

    static final class PracticeDarkButton implements PracticeButton {
        public String render() {
            return "TODO dark button";
        }
    }

    static final class PracticeDarkThemeFactory implements PracticeThemeFactory {
        public PracticeButton button() {
            return new PracticeDarkButton();
        }
    }

    static final class PracticeReport {
        private final String title;
        private final String body;

        private PracticeReport(Builder builder) {
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

            PracticeReport build() {
                // TODO: Builder task
                // Validate required fields before creating PracticeReport.
                return new PracticeReport(this);
            }
        }
    }

    record PracticeCourseTemplate(String name, String status) {
        PracticeCourseTemplate copyWithStatus(String newStatus) {
            // TODO: Prototype task
            // Return a copied object with the new status.
            return this;
        }
    }
}
