package com.lld.gof.creational.abstractfactory.practice;

public class AbstractFactoryPractice {
    public static void main(String[] args) {
        PracticeThemeFactory factory = new PracticeDarkThemeFactory();

        System.out.println(factory.button().render());
        System.out.println(factory.textBox().render());
    }

    /*
     * Abstract Factory Practice
     *
     * Goal:
     * Produce a related family of objects from one factory.
     *
     * Learning task:
     * Add PracticeLightThemeFactory with light button and light text box.
     * Main should only switch the factory object.
     */
    interface PracticeButton {
        String render();
    }

    interface PracticeTextBox {
        String render();
    }

    interface PracticeThemeFactory {
        PracticeButton button();

        PracticeTextBox textBox();
    }

    static final class PracticeDarkButton implements PracticeButton {
        public String render() {
            return "TODO dark button";
        }
    }

    static final class PracticeDarkTextBox implements PracticeTextBox {
        public String render() {
            return "TODO dark text box";
        }
    }

    static final class PracticeDarkThemeFactory implements PracticeThemeFactory {
        public PracticeButton button() {
            // TODO: Return dark button.
            return new PracticeDarkButton();
        }

        public PracticeTextBox textBox() {
            // TODO: Return dark text box.
            return new PracticeDarkTextBox();
        }
    }
}
