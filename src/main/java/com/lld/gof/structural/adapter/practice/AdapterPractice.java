package com.lld.gof.structural.adapter.practice;

public class AdapterPractice {
    public static void main(String[] args) {
        PracticePaymentGateway gateway = new PracticeLegacyGatewayAdapter(new PracticeLegacyGateway());
        System.out.println(gateway.pay(500));
    }

    /*
     * Adapter Practice
     *
     * Goal:
     * Translate the new interface into the old class method.
     */
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
            // Call legacyGateway.makePayment(amount) and return its result.
            return "TODO adapter";
        }
    }
}
