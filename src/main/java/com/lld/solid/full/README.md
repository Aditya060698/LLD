# SOLID Reference Implementation

This package uses a checkout flow to demonstrate SOLID plus DRY, KISS, and YAGNI.

## SRP: Single Responsibility Principle

A class should have one reason to change.

Examples:

- `Order` stores order state.
- `OrderTotalCalculator` calculates totals.
- `SimpleInvoiceFormatter` formats invoices.
- `CheckoutService` coordinates checkout but does not calculate totals, process payment, or send messages itself.

## OCP: Open/Closed Principle

Code should be open for extension but closed for modification.

Examples:

- `DiscountPolicy` lets us add `NoDiscountPolicy`, `PercentageDiscountPolicy`, or future discount types without changing `CheckoutService`.
- `PaymentProcessor` lets us add card, UPI, wallet, or net banking processors without changing checkout orchestration.

## LSP: Liskov Substitution Principle

Subtypes must be safely usable wherever the parent abstraction is expected.

Example:

- `CardPaymentProcessor` and `UpiPaymentProcessor` both honor the same `PaymentProcessor` contract.
- `CheckoutService` can use either processor without special checks.

## ISP: Interface Segregation Principle

Prefer small, focused interfaces over large interfaces that force unused methods.

Examples:

- `PaymentProcessor` only processes payment.
- `NotificationChannel` only sends notifications.
- `InvoiceFormatter` only formats invoices.
- `DiscountPolicy` only applies discount rules.

## DIP: Dependency Inversion Principle

High-level code should depend on abstractions, not concrete low-level classes.

Example:

- `CheckoutService` depends on `DiscountPolicy`, `PaymentProcessor`, `NotificationChannel`, and `InvoiceFormatter`.
- The demo wires concrete implementations from the outside.

## DRY: Don't Repeat Yourself

Avoid duplicating important knowledge.

Examples:

- Total calculation is centralized in `OrderTotalCalculator`.
- Payment result format is centralized in `PaymentReceipt`.
- Checkout orchestration is written once in `CheckoutService`.

## KISS: Keep It Simple

Prefer the simplest design that solves the current problem clearly.

Example:

- There is no framework or container here.
- Dependencies are passed directly through constructors.
- The domain is small enough to understand in one sitting.

## YAGNI: You Aren't Gonna Need It

Do not add features or abstractions before they are needed.

Examples:

- No coupon engine.
- No payment retry framework.
- No persistence layer.
- No event bus.

Those can be added later when the requirement actually appears.
