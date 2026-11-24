# Java OOP Pack

This package uses a course-enrollment domain to show core Java OOP concepts in one connected example.

## Concepts Covered

### Encapsulation

Encapsulation means keeping object data private and allowing changes only through controlled methods.

Examples:

- `Person.id` and `Person.name` are private.
- `Person.changeName()` validates the name.
- `Course.enroll()` controls how students are added.
- `Student.getEnrolledCourseCodes()` returns an unmodifiable list, so outside code cannot directly mutate the student's internal list.

### Abstraction

Abstraction means exposing what an object can do without exposing every implementation detail.

Examples:

- `Lesson` is an interface.
- `OopsConceptDemo` works with `Lesson`, not directly with only `VideoLesson` or `QuizLesson`.
- The caller only knows that a lesson can return `summary()` and `deliver()`.

### Inheritance

Inheritance means one class reuses and specializes another class.

Examples:

- `Person` is the parent class.
- `Student` and `Instructor` extend `Person`.
- Shared identity and name behavior stays in `Person`.

### Polymorphism

Polymorphism means the same reference type can point to different concrete object types, and the correct overridden behavior runs at runtime.

Examples:

- `List<Person>` contains both `Instructor` and `Student`.
- Calling `person.role()` executes different behavior depending on the actual object.
- `List<Lesson>` contains both `VideoLesson` and `QuizLesson`.
- Calling `lesson.deliver()` behaves differently for video and quiz lessons.

### Association

Association means one object knows or uses another object.

Example:

- `Course` has an `Instructor`.
- The instructor can exist without that course.
- This is a "uses/knows about" relationship.

### Aggregation

Aggregation is a weak whole-part relationship. The container groups objects, but those objects can live independently.

Example:

- `Department` has instructors and courses.
- If the department object is removed, the instructor and course objects may still exist elsewhere.

### Composition

Composition is a strong whole-part relationship. The part belongs to the whole conceptually and does not make much sense without it.

Example:

- `Course` owns `CourseModule` objects.
- `CourseModule` owns `Lesson` objects.
- In this model, modules and lessons are part of the course structure.

## Run

From repo root:

```powershell
javac -d out (Get-ChildItem -Recurse src/main/java -Filter *.java).FullName
java -cp out com.lld.oops.OopsConceptDemo
```
