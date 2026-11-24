# SOLID Practice Tasks

This package is your hands-on SOLID exercise area.

Use `com.lld.solid.full` as the reference only after you attempt the task yourself.

## Task 1: SRP

Implement these classes so each has one clear responsibility:

- `PracticeOrder`: manages order state and items.
- `PracticeOrderItem`: owns line total formula.
- `PracticeOrderTotalCalculator`: calculates subtotal.
- `PracticeSimpleInvoiceFormatter`: formats invoice text.
- `PracticeCheckoutService`: only coordinates checkout.

Rule: do not put subtotal calculation, discount logic, payment logic, and notification logic all inside `PracticeCheckoutService`.

## Task 2: OCP

Complete:

- `PracticeDiscountPolicy`
- `PracticeNoDiscountPolicy`
- `PracticePercentageDiscountPolicy`

Then add a new class:

- `PracticeFixedAmountDiscountPolicy`

Important: after adding the new discount class, `PracticeCheckoutService` should not need to change.

## Task 3: LSP

Complete:

- `PracticeCardPaymentProcessor`
- `PracticeUpiPaymentProcessor`

Both must obey the `PracticePaymentProcessor` contract.

Rules:

- Do not return `null`.
- Return a valid `PracticePaymentReceipt`.
- `PracticeCheckoutService` should work with either implementation.

## Task 4: ISP

Study these small interfaces:

- `PracticePaymentProcessor`
- `PracticeNotificationChannel`
- `PracticeInvoiceFormatter`
- `PracticeDiscountPolicy`

Do not merge them into one large `CheckoutOperations` interface.

Reason: payment classes should not be forced to implement invoice or notification methods.

## Task 5: DIP

Complete `PracticeCheckoutService`.

Rules:

- Depend on abstractions like `PracticePaymentProcessor`, not concrete classes like `PracticeCardPaymentProcessor`.
- Receive dependencies through the constructor.
- Do not instantiate payment processors, notification channels, or discount policies inside checkout.

## Task 6: DRY

Avoid repeating formulas and formatting:

- Line total formula belongs in `PracticeOrderItem.lineTotal()`.
- Subtotal logic belongs in `PracticeOrderTotalCalculator`.
- Payment message format belongs in `PracticePaymentReceipt.message()`.

## Task 7: KISS

Keep the solution simple:

- No frameworks.
- No reflection.
- No generic rule engine.
- No unnecessary inheritance.

Use interfaces only where they create a real extension point.

## Task 8: YAGNI

Do not add features that are not required yet:

- No database.
- No coupon stacking.
- No payment retries.
- No async queue.
- No event bus.

Interview note: YAGNI does not mean "never design for change." It means design for known variation, not imaginary variation.

## Run

From repo root:

```powershell
javac -d out (Get-ChildItem -Recurse src/main/java -Filter *.java).FullName
java -cp out com.lld.solid.practice.SolidPracticeRunner
```
