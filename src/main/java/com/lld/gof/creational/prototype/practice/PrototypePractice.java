package com.lld.gof.creational.prototype.practice;

public class PrototypePractice {
    public static void main(String[] args) {
        PracticeCourseTemplate draft = new PracticeCourseTemplate("LLD", "draft", 10);
        PracticeCourseTemplate publishedCopy = draft.copyWithStatus("published");

        System.out.println(draft);
        System.out.println(publishedCopy);
    }

    /*
     * Prototype Practice
     *
     * Goal:
     * Copy an existing object instead of building a fresh object manually.
     *
     * Learning task:
     * The copy should preserve unchanged fields and replace only the requested field.
     */
    record PracticeCourseTemplate(String name, String status, int moduleCount) {
        PracticeCourseTemplate copyWithStatus(String newStatus) {
            // TODO: Prototype task
            // Validate newStatus.
            // Return a new object with the same name/moduleCount and new status.
            return this;
        }
    }
}
