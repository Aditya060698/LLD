package com.lld.gof.behavioral.templatemethod.solution;

public class TemplateMethodSolution {
    public static void main(String[] args) {
        DataImporter importer = new CsvImporter();
        System.out.println(importer.importData());
    }

    /*
     * Template Method Pattern
     *
     * Intent:
     * Define algorithm skeleton in parent class and let subclasses fill steps.
     */
    abstract static class DataImporter {
        final String importData() {
            return read() + " -> " + parse() + " -> saved";
        }

        abstract String read();

        abstract String parse();
    }

    static final class CsvImporter extends DataImporter {
        String read() {
            return "csv";
        }

        String parse() {
            return "rows";
        }
    }
}
