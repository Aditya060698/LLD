# Java OOP Practice Tasks

Use this folder for hands-on implementation. The complete version in `com.lld.oops.domain` is your reference, but try to solve this practice package first.

## Task 1: Encapsulation

Implement validation and safe access in:

- `PersonPractice`
- `StudentPractice`
- `InstructorPractice`
- `CoursePractice`
- `DepartmentPractice`
- `VideoLessonPractice`
- `QuizLessonPractice`

Rules:

- Required text fields must not be `null` or blank.
- Numeric values like capacity, duration, and question count must be positive.
- Internal lists must not be directly mutable from outside the class.
- Duplicate enrollment should not happen.

## Task 2: Abstraction

Study `LessonPractice`.

Then make sure both of these classes correctly implement the contract:

- `VideoLessonPractice`
- `QuizLessonPractice`

After that, create a new class:

- `AssignmentLessonPractice`

It should also implement `LessonPractice`.

## Task 3: Inheritance

Study `PersonPractice`.

Then complete:

- `StudentPractice.role()`
- `InstructorPractice.role()`

Both classes inherit identity and name behavior from `PersonPractice`, but each class must return its own role.

## Task 4: Polymorphism

In `PracticeRunner`, add your new `AssignmentLessonPractice` like this:

```java
LessonPractice assignmentLesson = new AssignmentLessonPractice("Design a Course System", 100);
printLesson(assignmentLesson);
```

The important point: `printLesson()` should not need to know the concrete lesson type.

## Task 5: Relationships

Add these examples in `PracticeRunner`:

- Association: a `CoursePractice` uses or knows a `StudentPractice` during enrollment.
- Aggregation: a `DepartmentPractice` groups `InstructorPractice` and `CoursePractice`.
- Composition: create a `CourseModulePractice` class that owns lesson objects.

## Expected Learning

By the end of this pack, you should be able to explain:

- Why private fields are not enough for encapsulation.
- Why abstraction is more than just using an interface.
- Why inheritance and polymorphism are related but not the same.
- How association, aggregation, and composition differ in ownership strength.
