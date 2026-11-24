package com.lld.gof.behavioral.interpreter.solution;

import java.util.Map;

public class InterpreterSolution {
    public static void main(String[] args) {
        Expression expression = new Add(new Variable("x"), new NumberValue(5));
        System.out.println(expression.interpret(Map.of("x", 10)));
    }

    /*
     * Interpreter Pattern
     *
     * Intent:
     * Represent grammar rules as classes and evaluate expressions.
     */
    interface Expression {
        int interpret(Map<String, Integer> context);
    }

    record NumberValue(int value) implements Expression {
        public int interpret(Map<String, Integer> context) {
            return value;
        }
    }

    record Variable(String name) implements Expression {
        public int interpret(Map<String, Integer> context) {
            return context.getOrDefault(name, 0);
        }
    }

    record Add(Expression left, Expression right) implements Expression {
        public int interpret(Map<String, Integer> context) {
            return left.interpret(context) + right.interpret(context);
        }
    }
}
