package com.lld.gof.creational.prototype.solution;

public class PrototypeSolution {
    public static void main(String[] args) {
        CourseTemplate draft = new CourseTemplate("LLD", "draft", 10);
        CourseTemplate publishedCopy = draft.copyWithStatus("published");

        System.out.println(draft);
        System.out.println(publishedCopy);
    }

    /*
     * Prototype Pattern
     *
     * Intent:
     * Create new objects by copying an existing object.
     *
     * Good use case:
     * Object creation is expensive or a base template is reused often.
     */
    record CourseTemplate(String name, String status, int moduleCount) {
        CourseTemplate copyWithStatus(String newStatus) {
            if (newStatus == null || newStatus.isBlank()) {
                throw new IllegalArgumentException("status is required");
            }
            return new CourseTemplate(name, newStatus, moduleCount);
        }
    }
}
