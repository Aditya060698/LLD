package com.lld.gof.structural.adapter.solution;

public class AdapterSolution {
    public static void main(String[] args) {
        PaymentGateway gateway = new LegacyGatewayAdapter(new LegacyGateway());
        System.out.println(gateway.pay(500));
    }

    /*
     * Adapter Pattern
     *
     * Intent:
     * Make an incompatible class work with the interface your code expects.
     *
     * Here:
     * Client wants PaymentGateway.pay().
     * LegacyGateway only has makePayment().
     */
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
}
