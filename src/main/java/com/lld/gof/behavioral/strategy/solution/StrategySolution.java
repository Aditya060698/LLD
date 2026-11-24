package com.lld.gof.behavioral.strategy.solution;

public class StrategySolution {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator(new FestivalPricing());
        System.out.println(calculator.price(1000));
    }

    /*
     * Strategy Pattern
     *
     * Intent:
     * Select an algorithm at runtime by plugging in a strategy object.
     */
    interface PricingStrategy {
        int price(int base);
    }

    static final class FestivalPricing implements PricingStrategy {
        public int price(int base) {
            return base - 100;
        }
    }

    record PriceCalculator(PricingStrategy strategy) {
        int price(int base) {
            return strategy.price(base);
        }
    }
}
