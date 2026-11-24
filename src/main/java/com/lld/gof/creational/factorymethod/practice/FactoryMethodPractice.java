package com.lld.gof.creational.factorymethod.practice;

public class FactoryMethodPractice {
    public static void main(String[] args) {
        PracticeNotificationFactory factory = new PracticeEmailNotificationFactory();
        PracticeNotification notification = factory.createNotification();

        System.out.println(notification.send("Welcome to LLD"));
    }

    /*
     * Factory Method Practice
     *
     * Goal:
     * Creation logic should live in factory subclasses.
     *
     * Learning check:
     * Add PracticeSmsNotification and PracticeSmsNotificationFactory
     * without changing the client code style in main.
     */
    interface PracticeNotification {
        String send(String message);
    }

    static final class PracticeEmailNotification implements PracticeNotification {
        public String send(String message) {
            // TODO: Return email-specific behavior.
            return "TODO email";
        }
    }

    abstract static class PracticeNotificationFactory {
        // TODO: Factory Method task
        // This method is the factory method.
        abstract PracticeNotification createNotification();
    }

    static final class PracticeEmailNotificationFactory extends PracticeNotificationFactory {
        PracticeNotification createNotification() {
            // TODO: Return the correct concrete notification.
            return new PracticeEmailNotification();
        }
    }
}
