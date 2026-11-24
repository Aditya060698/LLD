package com.lld.gof.structural.bridge.practice;

public class BridgePractice {
    public static void main(String[] args) {
        PracticeNotificationChannel channel = new PracticeEmailChannel(new PracticeHtmlFormat());
        System.out.println(channel.send("Welcome"));
    }

    /*
     * Bridge Practice
     *
     * Goal:
     * Do not hard-code message formatting inside the channel.
     */
    interface PracticeMessageFormat {
        String format(String message);
    }

    static final class PracticeHtmlFormat implements PracticeMessageFormat {
        public String format(String message) {
            // TODO: Bridge task
            // Return HTML formatted message.
            return "TODO html";
        }
    }

    abstract static class PracticeNotificationChannel {
        protected final PracticeMessageFormat format;

        PracticeNotificationChannel(PracticeMessageFormat format) {
            this.format = format;
        }

        abstract String send(String message);
    }

    static final class PracticeEmailChannel extends PracticeNotificationChannel {
        PracticeEmailChannel(PracticeMessageFormat format) {
            super(format);
        }

        String send(String message) {
            // TODO: Bridge task
            // Use format.format(message) instead of hard-coding HTML here.
            return "TODO bridge";
        }
    }
}
