package com.lld.gof.behavioral.strategy.practice;

public class StrategyPractice {
    public static void main(String[] args) {
        PracticePriceCalculator calculator = new PracticePriceCalculator(new PracticeFestivalPricing());
        System.out.println(calculator.price(1000));
    }

    /*
     * Strategy Practice
     *
     * Goal:
     * Add new pricing algorithms without editing PracticePriceCalculator.
     */
    interface PracticePricingStrategy {
        int price(int base);
    }

    static final class PracticeFestivalPricing implements PracticePricingStrategy {
        public int price(int base) {
            // TODO: Strategy task
            // Apply festival discount.
            return base;
        }
    }

    record PracticePriceCalculator(PracticePricingStrategy strategy) {
        int price(int base) {
            return strategy.price(base);
        }
    }
}
