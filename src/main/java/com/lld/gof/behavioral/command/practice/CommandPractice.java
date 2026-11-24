package com.lld.gof.behavioral.command.practice;

public class CommandPractice {
    public static void main(String[] args) {
        PracticeCommand command = new PracticeEnrollCommand("Rahul", "LLD");
        command.execute();
        System.out.println(command.undo());
    }

    /*
     * Command Practice
     *
     * Goal:
     * Store an action and its data in one command object.
     */
    interface PracticeCommand {
        void execute();

        String undo();
    }

    record PracticeEnrollCommand(String student, String course) implements PracticeCommand {
        public void execute() {
            // TODO: Command task
            // Print or perform enrollment.
            System.out.println("TODO execute enrollment");
        }

        public String undo() {
            // TODO: Command task
            // Return undo message.
            return "TODO undo enrollment";
        }
    }
}
