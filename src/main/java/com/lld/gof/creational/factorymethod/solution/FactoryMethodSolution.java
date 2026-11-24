package com.lld.gof.creational.factorymethod.solution;

public class FactoryMethodSolution {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification();

        System.out.println(notification.send("Welcome to LLD"));
    }

    /*
     * Factory Method Pattern
     *
     * Intent:
     * Let subclasses decide which concrete object to create.
     *
     * Important idea:
     * Client code depends on NotificationFactory and Notification,
     * not directly on EmailNotification.
     */
    interface Notification {
        String send(String message);
    }

    static final class EmailNotification implements Notification {
        public String send(String message) {
            return "Email sent: " + message;
        }
    }

    abstract static class NotificationFactory {
        abstract Notification createNotification();
    }

    static final class EmailNotificationFactory extends NotificationFactory {
        Notification createNotification() {
            return new EmailNotification();
        }
    }
}
