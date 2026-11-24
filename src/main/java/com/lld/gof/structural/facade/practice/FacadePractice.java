package com.lld.gof.structural.facade.practice;

public class FacadePractice {
    public static void main(String[] args) {
        PracticeCheckoutFacade facade = new PracticeCheckoutFacade();
        System.out.println(facade.placeOrder("LLD Course"));
    }

    /*
     * Facade Practice
     *
     * Goal:
     * Hide multiple subsystem calls behind one simple method.
     */
    static final class PracticeCheckoutFacade {
        String placeOrder(String item) {
            // TODO: Facade task
            // Call inventory, payment, and notification steps here.
            // Keep main simple.
            return "TODO facade";
        }
    }
}
