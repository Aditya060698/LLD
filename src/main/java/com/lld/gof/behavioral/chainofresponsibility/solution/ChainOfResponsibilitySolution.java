package com.lld.gof.behavioral.chainofresponsibility.solution;

public class ChainOfResponsibilitySolution {
    public static void main(String[] args) {
        Handler chain = new AuthHandler(new ValidationHandler(null));
        System.out.println(chain.handle("valid-token"));
    }

    /*
     * Chain of Responsibility Pattern
     *
     * Intent:
     * Pass a request through a chain until one handler processes it.
     */
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
}
