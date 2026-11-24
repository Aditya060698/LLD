package com.lld.gof.behavioral.chainofresponsibility.practice;

public class ChainOfResponsibilityPractice {
    public static void main(String[] args) {
        PracticeHandler chain = new PracticeAuthHandler(new PracticeValidationHandler(null));
        System.out.println(chain.handle("valid-token"));
    }

    /*
     * Chain of Responsibility Practice
     *
     * Goal:
     * Each handler decides whether it can handle the request.
     * If not, it passes the request to the next handler.
     */
    abstract static class PracticeHandler {
        private final PracticeHandler next;

        PracticeHandler(PracticeHandler next) {
            this.next = next;
        }

        String handle(String request) {
            // TODO: Chain task
            // Call check(request). If it returns null, pass to next.
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
}
