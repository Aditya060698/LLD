package com.lld.gof.behavioral.interpreter.practice;

import java.util.Map;

public class InterpreterPractice {
    public static void main(String[] args) {
        PracticeExpression expression = new PracticeAdd(new PracticeVariable("x"), new PracticeNumberValue(5));
        System.out.println(expression.interpret(Map.of("x", 10)));
    }

    /*
     * Interpreter Practice
     *
     * Goal:
     * Build small expression objects and evaluate them using context.
     */
    interface PracticeExpression {
        int interpret(Map<String, Integer> context);
    }

    record PracticeNumberValue(int value) implements PracticeExpression {
        public int interpret(Map<String, Integer> context) {
            return value;
        }
    }

    record PracticeVariable(String name) implements PracticeExpression {
        public int interpret(Map<String, Integer> context) {
            // TODO: Interpreter task
            // Return value from context by variable name.
            return 0;
        }
    }

    record PracticeAdd(PracticeExpression left, PracticeExpression right) implements PracticeExpression {
        public int interpret(Map<String, Integer> context) {
            // TODO: Interpreter task
            // Interpret both sides and add the results.
            return 0;
        }
    }
}
