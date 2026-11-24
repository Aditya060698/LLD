package com.lld.gof.structural.bridge.solution;

public class BridgeSolution {
    public static void main(String[] args) {
        NotificationChannel channel = new EmailChannel(new HtmlFormat());
        System.out.println(channel.send("Welcome"));
    }

    /*
     * Bridge Pattern
     *
     * Intent:
     * Split abstraction and implementation so both can vary independently.
     *
     * Here:
     * Channel can vary: Email, SMS.
     * Format can vary: HTML, Plain text.
     */
    interface MessageFormat {
        String format(String message);
    }

    static final class HtmlFormat implements MessageFormat {
        public String format(String message) {
            return "<b>" + message + "</b>";
        }
    }

    abstract static class NotificationChannel {
        protected final MessageFormat format;

        NotificationChannel(MessageFormat format) {
            this.format = format;
        }

        abstract String send(String message);
    }

    static final class EmailChannel extends NotificationChannel {
        EmailChannel(MessageFormat format) {
            super(format);
        }

        String send(String message) {
            return "email: " + format.format(message);
        }
    }
}
