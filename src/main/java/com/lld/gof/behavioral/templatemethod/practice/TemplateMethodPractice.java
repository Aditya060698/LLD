package com.lld.gof.behavioral.templatemethod.practice;

public class TemplateMethodPractice {
    public static void main(String[] args) {
        PracticeDataImporter importer = new PracticeCsvImporter();
        System.out.println(importer.importData());
    }

    /*
     * Template Method Practice
     *
     * Goal:
     * Parent controls algorithm order. Child fills specific steps.
     */
    abstract static class PracticeDataImporter {
        final String importData() {
            // TODO: Template Method task
            // Keep fixed order: read -> parse -> save.
            return read() + " -> " + parse();
        }

        abstract String read();

        abstract String parse();
    }

    static final class PracticeCsvImporter extends PracticeDataImporter {
        String read() {
            return "TODO read csv";
        }

        String parse() {
            return "TODO parse csv";
        }
    }
}
