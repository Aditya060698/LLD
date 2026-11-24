package com.lld.gof.structural.decorator.solution;

public class DecoratorSolution {
    public static void main(String[] args) {
        DataSource source = new EncryptionDecorator(new FileDataSource());
        System.out.println(source.write("secret"));
    }

    /*
     * Decorator Pattern
     *
     * Intent:
     * Add behavior to an object by wrapping it.
     *
     * Here:
     * EncryptionDecorator adds encryption before delegating to FileDataSource.
     */
    interface DataSource {
        String write(String value);
    }

    static final class FileDataSource implements DataSource {
        public String write(String value) {
            return "file:" + value;
        }
    }

    static final class EncryptionDecorator implements DataSource {
        private final DataSource wrappee;

        EncryptionDecorator(DataSource wrappee) {
            this.wrappee = wrappee;
        }

        public String write(String value) {
            return wrappee.write("encrypted(" + value + ")");
        }
    }
}
