package com.lld.gof.behavioral.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BehavioralPracticeDemo {
    public static void main(String[] args) {
        PracticeHandler auth = new PracticeAuthHandler(new PracticeValidationHandler(null));
        System.out.println("Chain: " + auth.handle("valid-token"));

        PracticeCommand command = new PracticeEnrollCommand("Rahul", "LLD");
        command.execute();
        System.out.println("Command: " + command.undo());

        PracticeExpression expression = new PracticeVariable("x");
        System.out.println("Interpreter: " + expression.interpret(Map.of("x", 10)));

        PracticeCourseCollection courses = new PracticeCourseCollection(List.of("OOP", "SOLID"));
        System.out.println("Iterator: " + courses.iterator().next());

        PracticeChatRoom room = new PracticeChatRoom();
        System.out.println("Mediator: " + room.send("Rahul", "Hi"));

        PracticeEditor editor = new PracticeEditor();
        editor.type("draft");
        PracticeEditorMemento saved = editor.save();
        editor.type(" changed");
        editor.restore(saved);
        System.out.println("Memento: " + editor.text());

        PracticeCoursePublisher publisher = new PracticeCoursePublisher();
        publisher.addSubscriber(name -> System.out.println("Observer: " + name));
        publisher.publish("Design Patterns");

        PracticePlayer player = new PracticePlayer(new PracticePausedState());
        System.out.println("State: " + player.pressPlay());

        PracticePriceCalculator calculator = new PracticePriceCalculator(new PracticeRegularPricing());
        System.out.println("Strategy: " + calculator.price(100));

        PracticeDataImporter importer = new PracticeCsvImporter();
        System.out.println("Template: " + importer.importData());

        PracticeReportNode report = new PracticeTextNode("LLD");
        System.out.println("Visitor: " + report.accept(new PracticePlainTextVisitor()));
    }

    abstract static class PracticeHandler {
        private final PracticeHandler next;

        PracticeHandler(PracticeHandler next) {
            this.next = next;
        }

        String handle(String request) {
            // TODO: Chain of Responsibility task
            // Run this handler. If it cannot handle, pass to next.
            return check(request);
        }

        abstract String check(String request);
    }

    static final class PracticeAuthHandler extends PracticeHandler {
        PracticeAuthHandler(PracticeHandler next) {
            super(next);
        }

        String check(String request) {
            return "TODO auth";
        }
    }

    static final class PracticeValidationHandler extends PracticeHandler {
        PracticeValidationHandler(PracticeHandler next) {
            super(next);
        }

        String check(String request) {
            return "TODO validation";
        }
    }

    interface PracticeCommand {
        void execute();

        String undo();
    }

    record PracticeEnrollCommand(String student, String course) implements PracticeCommand {
        public void execute() {
            // TODO: Command task
            // Encapsulate the enrollment action.
            System.out.println("TODO execute");
        }

        public String undo() {
            return "TODO undo";
        }
    }

    interface PracticeExpression {
        int interpret(Map<String, Integer> context);
    }

    record PracticeVariable(String name) implements PracticeExpression {
        public int interpret(Map<String, Integer> context) {
            // TODO: Interpreter task
            // Resolve this variable using the context map.
            return 0;
        }
    }

    record PracticeCourseCollection(List<String> courses) {
        java.util.Iterator<String> iterator() {
            // TODO: Iterator task
            // Return an iterator without exposing traversal logic to callers.
            return courses.iterator();
        }
    }

    static final class PracticeChatRoom {
        String send(String sender, String message) {
            // TODO: Mediator task
            // Centralize communication through this object.
            return "TODO mediator";
        }
    }

    static final class PracticeEditor {
        private String text = "";

        void type(String value) {
            text += value;
        }

        PracticeEditorMemento save() {
            // TODO: Memento task
            // Capture current state.
            return new PracticeEditorMemento("");
        }

        void restore(PracticeEditorMemento memento) {
            // TODO: Memento task
            // Restore captured state.
        }

        String text() {
            return text;
        }
    }

    record PracticeEditorMemento(String text) {
    }

    interface PracticeSubscriber {
        void update(String courseName);
    }

    static final class PracticeCoursePublisher {
        private final List<PracticeSubscriber> subscribers = new ArrayList<>();

        void addSubscriber(PracticeSubscriber subscriber) {
            subscribers.add(subscriber);
        }

        void publish(String courseName) {
            // TODO: Observer task
            // Notify all subscribers.
        }
    }

    interface PracticePlayerState {
        String play();
    }

    static final class PracticePausedState implements PracticePlayerState {
        public String play() {
            // TODO: State task
            // Return behavior for paused state when play is pressed.
            return "TODO state";
        }
    }

    record PracticePlayer(PracticePlayerState state) {
        String pressPlay() {
            return state.play();
        }
    }

    interface PracticePricingStrategy {
        int price(int base);
    }

    static final class PracticeRegularPricing implements PracticePricingStrategy {
        public int price(int base) {
            // TODO: Strategy task
            // Return regular price.
            return 0;
        }
    }

    record PracticePriceCalculator(PracticePricingStrategy strategy) {
        int price(int base) {
            return strategy.price(base);
        }
    }

    abstract static class PracticeDataImporter {
        final String importData() {
            // TODO: Template Method task
            // Keep algorithm order fixed. Let subclasses fill steps.
            return read() + " -> " + parse();
        }

        abstract String read();

        abstract String parse();
    }

    static final class PracticeCsvImporter extends PracticeDataImporter {
        String read() {
            return "TODO read";
        }

        String parse() {
            return "TODO parse";
        }
    }

    interface PracticeReportNode {
        String accept(PracticeReportVisitor visitor);
    }

    record PracticeTextNode(String text) implements PracticeReportNode {
        public String accept(PracticeReportVisitor visitor) {
            // TODO: Visitor task
            // Dispatch to the visitor's text behavior.
            return "TODO visitor";
        }
    }

    interface PracticeReportVisitor {
        String visitText(PracticeTextNode node);
    }

    static final class PracticePlainTextVisitor implements PracticeReportVisitor {
        public String visitText(PracticeTextNode node) {
            return node.text();
        }
    }
}
