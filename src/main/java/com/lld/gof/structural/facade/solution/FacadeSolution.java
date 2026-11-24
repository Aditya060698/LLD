package com.lld.gof.structural.facade.solution;

public class FacadeSolution {
    public static void main(String[] args) {
        CheckoutFacade facade = new CheckoutFacade(new InventoryService(), new PaymentService(), new EmailService());
        System.out.println(facade.placeOrder("LLD Course"));
    }

    /*
     * Facade Pattern
     *
     * Intent:
     * Provide a simple API over a complex subsystem.
     *
     * Here:
     * Client calls placeOrder(), not reserve + pay + email separately.
     */
    static final class CheckoutFacade {
        private final InventoryService inventoryService;
        private final PaymentService paymentService;
        private final EmailService emailService;

        CheckoutFacade(InventoryService inventoryService, PaymentService paymentService, EmailService emailService) {
            this.inventoryService = inventoryService;
            this.paymentService = paymentService;
            this.emailService = emailService;
        }

        String placeOrder(String item) {
            return inventoryService.reserve(item) + " | " + paymentService.pay(item) + " | "
                    + emailService.send(item);
        }
    }

    static final class InventoryService {
        String reserve(String item) {
            return "reserved " + item;
        }
    }

    static final class PaymentService {
        String pay(String item) {
            return "paid for " + item;
        }
    }

    static final class EmailService {
        String send(String item) {
            return "email sent for " + item;
        }
    }
}
