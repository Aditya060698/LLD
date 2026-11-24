package com.lld.gof.structural.decorator.practice;

public class DecoratorPractice {
    public static void main(String[] args) {
        PracticeDataSource source = new PracticeEncryptionDecorator(new PracticeFileDataSource());
        System.out.println(source.write("secret"));
    }

    /*
     * Decorator Practice
     *
     * Goal:
     * Add behavior without changing PracticeFileDataSource.
     */
    interface PracticeDataSource {
        String write(String value);
    }

    static final class PracticeFileDataSource implements PracticeDataSource {
        public String write(String value) {
            return "file:" + value;
        }
    }

    static final class PracticeEncryptionDecorator implements PracticeDataSource {
        private final PracticeDataSource wrappee;

        PracticeEncryptionDecorator(PracticeDataSource wrappee) {
            this.wrappee = wrappee;
        }

        public String write(String value) {
            // TODO: Decorator task
            // Transform the value, then delegate to wrappee.write(...).
            return "TODO decorator";
        }
    }
}
