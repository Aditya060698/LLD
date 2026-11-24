package com.lld.gof.structural.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StructuralSolutionDemo {
    public static void main(String[] args) {
        PaymentGateway gateway = new LegacyGatewayAdapter(new LegacyGateway());
        System.out.println("Adapter: " + gateway.pay(500));

        NotificationChannel email = new EmailChannel(new HtmlMessage());
        System.out.println("Bridge: " + email.send("Welcome"));

        MenuGroup menu = new MenuGroup("Main", List.of(new MenuItem("Home"), new MenuItem("Courses")));
        System.out.println("Composite: " + menu.render());

        DataSource secured = new EncryptionDecorator(new FileDataSource());
        System.out.println("Decorator: " + secured.write("secret"));

        System.out.println("Facade: " + new CheckoutFacade().placeOrder("LLD Course"));
        System.out.println("Flyweight: " + IconFactory.get("course") + " / " + IconFactory.get("course"));
        System.out.println("Proxy: " + new CachedCourseRepository(new RealCourseRepository()).findById("C-1"));
    }

    interface PaymentGateway {
        String pay(int amount);
    }

    static final class LegacyGateway {
        String makePayment(int rupees) {
            return "legacy paid " + rupees;
        }
    }

    static final class LegacyGatewayAdapter implements PaymentGateway {
        private final LegacyGateway legacyGateway;

        LegacyGatewayAdapter(LegacyGateway legacyGateway) {
            this.legacyGateway = legacyGateway;
        }

        public String pay(int amount) {
            return legacyGateway.makePayment(amount);
        }
    }

    interface MessageFormat {
        String format(String message);
    }

    static final class HtmlMessage implements MessageFormat {
        public String format(String message) {
            return "<b>" + message + "</b>";
        }
    }

    abstract static class NotificationChannel {
        protected final MessageFormat format;

        NotificationChannel(MessageFormat format) {
            this.format = format;
        }

        abstract String send(String message);
    }

    static final class EmailChannel extends NotificationChannel {
        EmailChannel(MessageFormat format) {
            super(format);
        }

        String send(String message) {
            return "Email " + format.format(message);
        }
    }

    interface MenuComponent {
        String render();
    }

    record MenuItem(String label) implements MenuComponent {
        public String render() {
            return label;
        }
    }

    record MenuGroup(String label, List<MenuComponent> children) implements MenuComponent {
        public String render() {
            return label + children.stream().map(MenuComponent::render).toList();
        }
    }

    interface DataSource {
        String write(String value);
    }

    static final class FileDataSource implements DataSource {
        public String write(String value) {
            return "file:" + value;
        }
    }

    static final class EncryptionDecorator implements DataSource {
        private final DataSource wrappee;

        EncryptionDecorator(DataSource wrappee) {
            this.wrappee = wrappee;
        }

        public String write(String value) {
            return wrappee.write("encrypted(" + value + ")");
        }
    }

    static final class CheckoutFacade {
        String placeOrder(String item) {
            return "reserved stock, paid, notified for " + item;
        }
    }

    record Icon(String type) {
    }

    static final class IconFactory {
        private static final Map<String, Icon> CACHE = new HashMap<>();

        static Icon get(String type) {
            return CACHE.computeIfAbsent(type, Icon::new);
        }
    }

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
