package com.lld.gof.behavioral.command.solution;

public class CommandSolution {
    public static void main(String[] args) {
        Command command = new EnrollCommand("Rahul", "LLD");
        command.execute();
        System.out.println(command.undo());
    }

    /*
     * Command Pattern
     *
     * Intent:
     * Encapsulate a request as an object.
     */
    interface Command {
        void execute();

        String undo();
    }

    record EnrollCommand(String student, String course) implements Command {
        public void execute() {
            System.out.println(student + " enrolled in " + course);
        }

        public String undo() {
            return student + " removed from " + course;
        }
    }
}
