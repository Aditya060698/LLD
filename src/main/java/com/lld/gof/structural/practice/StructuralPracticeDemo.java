package com.lld.gof.structural.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructuralPracticeDemo {
    public static void main(String[] args) {
        PracticePaymentGateway gateway = new PracticeLegacyGatewayAdapter(new PracticeLegacyGateway());
        System.out.println("Adapter: " + gateway.pay(500));

        PracticeNotificationChannel email = new PracticeEmailChannel(new PracticeHtmlMessage());
        System.out.println("Bridge: " + email.send("Welcome"));

        PracticeMenuGroup menu = new PracticeMenuGroup("Main", List.of(new PracticeMenuItem("Home")));
        System.out.println("Composite: " + menu.render());

        PracticeDataSource secured = new PracticeEncryptionDecorator(new PracticeFileDataSource());
        System.out.println("Decorator: " + secured.write("secret"));

        System.out.println("Facade: " + new PracticeCheckoutFacade().placeOrder("LLD Course"));
        System.out.println("Flyweight: " + PracticeIconFactory.get("course"));
        System.out.println("Proxy: " + new PracticeCachedCourseRepository(new PracticeRealCourseRepository()).findById("C-1"));
    }

    interface PracticePaymentGateway {
        String pay(int amount);
    }

    static final class PracticeLegacyGateway {
        String makePayment(int rupees) {
            return "legacy paid " + rupees;
        }
    }

    static final class PracticeLegacyGatewayAdapter implements PracticePaymentGateway {
        private final PracticeLegacyGateway legacyGateway;

        PracticeLegacyGatewayAdapter(PracticeLegacyGateway legacyGateway) {
            this.legacyGateway = legacyGateway;
        }

        public String pay(int amount) {
            // TODO: Adapter task
            // Convert the new interface call into the legacy gateway call.
            return "TODO adapter";
        }
    }

    interface PracticeMessageFormat {
        String format(String message);
    }

    static final class PracticeHtmlMessage implements PracticeMessageFormat {
        public String format(String message) {
            return "TODO html";
        }
    }

    abstract static class PracticeNotificationChannel {
        protected final PracticeMessageFormat format;

        PracticeNotificationChannel(PracticeMessageFormat format) {
            this.format = format;
        }

        abstract String send(String message);
    }

    static final class PracticeEmailChannel extends PracticeNotificationChannel {
        PracticeEmailChannel(PracticeMessageFormat format) {
            super(format);
        }

        String send(String message) {
            // TODO: Bridge task
            // Use the format abstraction instead of hard-coding formatting.
            return "TODO bridge";
        }
    }

    interface PracticeMenuComponent {
        String render();
    }

    record PracticeMenuItem(String label) implements PracticeMenuComponent {
        public String render() {
            return label;
        }
    }

    record PracticeMenuGroup(String label, List<PracticeMenuComponent> children) implements PracticeMenuComponent {
        public String render() {
            // TODO: Composite task
            // Render child components through the common interface.
            return "TODO composite";
        }
    }

    interface PracticeDataSource {
        String write(String value);
    }

    static final class PracticeFileDataSource implements PracticeDataSource {
        public String write(String value) {
            return "file:" + value;
        }
    }

    static final class PracticeEncryptionDecorator implements PracticeDataSource {
        private final PracticeDataSource wrappee;

        PracticeEncryptionDecorator(PracticeDataSource wrappee) {
            this.wrappee = wrappee;
        }

        public String write(String value) {
            // TODO: Decorator task
            // Add encryption behavior and delegate to wrappee.
            return "TODO decorator";
        }
    }

    static final class PracticeCheckoutFacade {
        String placeOrder(String item) {
            // TODO: Facade task
            // Hide stock, payment, and notification steps behind this simple method.
            return "TODO facade";
        }
    }

    record PracticeIcon(String type) {
    }

    static final class PracticeIconFactory {
        private static final Map<String, PracticeIcon> CACHE = new HashMap<>();

        static PracticeIcon get(String type) {
            // TODO: Flyweight task
            // Reuse existing icon objects for the same type.
            return new PracticeIcon(type);
        }
    }

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
            // Add caching while preserving the same repository interface.
            return realRepository.findById(id);
        }
    }
}
