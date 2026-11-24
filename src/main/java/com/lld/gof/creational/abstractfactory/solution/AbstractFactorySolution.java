package com.lld.gof.creational.abstractfactory.solution;

public class AbstractFactorySolution {
    public static void main(String[] args) {
        ThemeFactory factory = new DarkThemeFactory();

        System.out.println(factory.button().render());
        System.out.println(factory.textBox().render());
    }

    /*
     * Abstract Factory Pattern
     *
     * Intent:
     * Create families of related objects without specifying concrete classes.
     *
     * Example:
     * Dark theme creates dark button + dark text box.
     * Light theme would create light button + light text box.
     */
    interface Button {
        String render();
    }

    interface TextBox {
        String render();
    }

    interface ThemeFactory {
        Button button();

        TextBox textBox();
    }

    static final class DarkButton implements Button {
        public String render() {
            return "Dark button";
        }
    }

    static final class DarkTextBox implements TextBox {
        public String render() {
            return "Dark text box";
        }
    }

    static final class DarkThemeFactory implements ThemeFactory {
        public Button button() {
            return new DarkButton();
        }

        public TextBox textBox() {
            return new DarkTextBox();
        }
    }
}
