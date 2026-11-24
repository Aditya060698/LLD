package com.lld.gof.structural.composite.practice;

import java.util.List;

public class CompositePractice {
    public static void main(String[] args) {
        PracticeMenuComponent menu = new PracticeMenuGroup("Main", List.of(new PracticeMenuItem("Home")));
        System.out.println(menu.render());
    }

    /*
     * Composite Practice
     *
     * Goal:
     * Caller should use PracticeMenuComponent for both item and group.
     */
    interface PracticeMenuComponent {
        String render();
    }

    record PracticeMenuItem(String label) implements PracticeMenuComponent {
        public String render() {
            return label;
        }
    }

    record PracticeMenuGroup(String label, List<PracticeMenuComponent> children)
            implements PracticeMenuComponent {
        public String render() {
            // TODO: Composite task
            // Render every child through PracticeMenuComponent.render().
            return "TODO composite";
        }
    }
}
