# GoF Design Patterns

There are 23 Gang of Four design patterns.

This section is split into three folders:

- `creational`: object creation patterns
- `structural`: object composition/wrapping patterns
- `behavioral`: object communication/algorithm patterns

Each category has two learning formats:

- A category-level quick demo, for example `creational/solution/CreationalSolutionDemo.java`.
- Pattern-level folders, where every pattern has its own `solution` and `practice` subfolder.

## Folder Style

Every individual pattern now follows this structure:

```text
pattern-name/
  solution/  -> complete reference implementation with comments
  practice/  -> half-done TODO version for hands-on learning
```

Example:

```text
creational/
  singleton/
    solution/SingletonSolution.java
    practice/SingletonPractice.java
```

## Pattern Folders

Creational:

- `singleton`
- `factorymethod`
- `abstractfactory`
- `builder`
- `prototype`

Structural:

- `adapter`
- `bridge`
- `composite`
- `decorator`
- `facade`
- `flyweight`
- `proxy`

Behavioral:

- `chainofresponsibility`
- `command`
- `interpreter`
- `iterator`
- `mediator`
- `memento`
- `observer`
- `state`
- `strategy`
- `templatemethod`
- `visitor`

## Suggested Order

Start with the popular interview patterns first:

1. Singleton
2. Factory Method
3. Abstract Factory
4. Builder
5. Strategy
6. Observer
7. Decorator
8. Adapter
9. Facade
10. Command
11. Template Method

Then finish the remaining GoF patterns.
