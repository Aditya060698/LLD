package com.lld.oops.practice;

public class PracticeRunner {
    public static void main(String[] args) {
        StudentPractice student = new StudentPractice("S-101", "Rahul");
        CoursePractice course = new CoursePractice("C-OOP", "Java OOP Mastery", 2);

        course.enroll(student);

        LessonPractice videoLesson = new VideoLessonPractice("Encapsulation", 20);
        LessonPractice quizLesson = new QuizLessonPractice("Abstraction Quiz", 5);

        System.out.println("=== Encapsulation ===");
        System.out.println(student.getName() + " enrolled in " + student.getEnrolledCourseCodes());

        System.out.println();
        System.out.println("=== Abstraction + Polymorphism ===");
        printLesson(videoLesson);
        printLesson(quizLesson);

        System.out.println();
        System.out.println("=== Inheritance + Polymorphism ===");
        PersonPractice person = student;
        System.out.println(person.getName() + " -> " + person.role());
    }

    private static void printLesson(LessonPractice lesson) {
        System.out.println(lesson.summary());
        lesson.deliver();
    }
}
