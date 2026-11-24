package com.lld.gof.behavioral.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BehavioralSolutionDemo {
    public static void main(String[] args) {
        Handler auth = new AuthHandler(new ValidationHandler(null));
        System.out.println("Chain: " + auth.handle("valid-token"));

        Command command = new EnrollCommand("Rahul", "LLD");
        command.execute();
        System.out.println("Command: " + command.undo());

        Expression expression = new Variable("x");
        System.out.println("Interpreter: " + expression.interpret(Map.of("x", 10)));

        CourseCollection courses = new CourseCollection(List.of("OOP", "SOLID"));
        System.out.println("Iterator: " + courses.iterator().next());

        ChatRoom room = new ChatRoom();
        System.out.println("Mediator: " + room.send("Rahul", "Hi"));

        Editor editor = new Editor();
        editor.type("draft");
        EditorMemento saved = editor.save();
        editor.type(" changed");
        editor.restore(saved);
        System.out.println("Memento: " + editor.text());

        CoursePublisher publisher = new CoursePublisher();
        publisher.addSubscriber(name -> System.out.println("Observer: " + name));
        publisher.publish("Design Patterns");

        Player player = new Player(new PausedState());
        System.out.println("State: " + player.pressPlay());

        PriceCalculator calculator = new PriceCalculator(new RegularPricing());
        System.out.println("Strategy: " + calculator.price(100));

        DataImporter importer = new CsvImporter();
        System.out.println("Template: " + importer.importData());

        ReportNode report = new SectionNode(List.of(new TextNode("LLD")));
        System.out.println("Visitor: " + report.accept(new PlainTextVisitor()));
    }

    abstract static class Handler {
        private final Handler next;

        Handler(Handler next) {
            this.next = next;
        }

        String handle(String request) {
            String result = check(request);
            return result != null || next == null ? result : next.handle(request);
        }

        abstract String check(String request);
    }

    static final class AuthHandler extends Handler {
        AuthHandler(Handler next) {
            super(next);
        }

        String check(String request) {
            return request.startsWith("valid") ? null : "unauthorized";
        }
    }

    static final class ValidationHandler extends Handler {
        ValidationHandler(Handler next) {
            super(next);
        }

        String check(String request) {
            return request.isBlank() ? "invalid" : "accepted";
        }
    }

    interface Command {
        void execute();

        String undo();
    }

    record EnrollCommand(String student, String course) implements Command {
        public void execute() {
            System.out.println(student + " enrolled in " + course);
        }

        public String undo() {
            return student + " removed from " + course;
        }
    }

    interface Expression {
        int interpret(Map<String, Integer> context);
    }

    record Variable(String name) implements Expression {
        public int interpret(Map<String, Integer> context) {
            return context.getOrDefault(name, 0);
        }
    }

    record CourseCollection(List<String> courses) {
        java.util.Iterator<String> iterator() {
            return courses.iterator();
        }
    }

    static final class ChatRoom {
        String send(String sender, String message) {
            return sender + " says " + message;
        }
    }

    static final class Editor {
        private String text = "";

        void type(String value) {
            text += value;
        }

        EditorMemento save() {
            return new EditorMemento(text);
        }

        void restore(EditorMemento memento) {
            text = memento.text();
        }

        String text() {
            return text;
        }
    }

    record EditorMemento(String text) {
    }

    interface Subscriber {
        void update(String courseName);
    }

    static final class CoursePublisher {
        private final List<Subscriber> subscribers = new ArrayList<>();

        void addSubscriber(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        void publish(String courseName) {
            subscribers.forEach(subscriber -> subscriber.update(courseName));
        }
    }

    interface PlayerState {
        String play();
    }

    static final class PausedState implements PlayerState {
        public String play() {
            return "playing";
        }
    }

    record Player(PlayerState state) {
        String pressPlay() {
            return state.play();
        }
    }

    interface PricingStrategy {
        int price(int base);
    }

    static final class RegularPricing implements PricingStrategy {
        public int price(int base) {
            return base;
        }
    }

    record PriceCalculator(PricingStrategy strategy) {
        int price(int base) {
            return strategy.price(base);
        }
    }

    abstract static class DataImporter {
        final String importData() {
            return read() + " -> " + parse() + " -> saved";
        }

        abstract String read();

        abstract String parse();
    }

    static final class CsvImporter extends DataImporter {
        String read() {
            return "csv";
        }

        String parse() {
            return "rows";
        }
    }

    interface ReportNode {
        String accept(ReportVisitor visitor);
    }

    record TextNode(String text) implements ReportNode {
        public String accept(ReportVisitor visitor) {
            return visitor.visitText(this);
        }
    }

    record SectionNode(List<ReportNode> children) implements ReportNode {
        public String accept(ReportVisitor visitor) {
            return visitor.visitSection(this);
        }
    }

    interface ReportVisitor {
        String visitText(TextNode node);

        String visitSection(SectionNode node);
    }

    static final class PlainTextVisitor implements ReportVisitor {
        public String visitText(TextNode node) {
            return node.text();
        }

        public String visitSection(SectionNode node) {
            return node.children().stream().map(child -> child.accept(this)).toList().toString();
        }
    }
}
