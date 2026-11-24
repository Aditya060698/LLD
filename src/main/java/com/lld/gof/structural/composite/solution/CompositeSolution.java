package com.lld.gof.structural.composite.solution;

import java.util.List;

public class CompositeSolution {
    public static void main(String[] args) {
        MenuComponent menu = new MenuGroup("Main", List.of(new MenuItem("Home"), new MenuItem("Courses")));
        System.out.println(menu.render());
    }

    /*
     * Composite Pattern
     *
     * Intent:
     * Treat individual objects and groups uniformly.
     *
     * Here:
     * MenuItem is a leaf.
     * MenuGroup is a composite containing MenuComponent children.
     */
    interface MenuComponent {
        String render();
    }

    record MenuItem(String label) implements MenuComponent {
        public String render() {
            return label;
        }
    }

    record MenuGroup(String label, List<MenuComponent> children) implements MenuComponent {
        public String render() {
            return label + children.stream().map(MenuComponent::render).toList();
        }
    }
}
