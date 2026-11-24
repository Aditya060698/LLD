package com.lld.oops;

import com.lld.oops.domain.Course;
import com.lld.oops.domain.CourseModule;
import com.lld.oops.domain.Department;
import com.lld.oops.domain.Instructor;
import com.lld.oops.domain.Lesson;
import com.lld.oops.domain.Person;
import com.lld.oops.domain.QuizLesson;
import com.lld.oops.domain.Student;
import com.lld.oops.domain.VideoLesson;

import java.util.List;

public class OopsConceptDemo {
    public static void main(String[] args) {
        Instructor instructor = new Instructor("I-101", "Ananya", "Low Level Design");
        Student student = new Student("S-501", "Rahul");

        Course lldCourse = new Course(
                "C-LLD",
                "Low Level Design Mastery",
                instructor,
                2
        );

        CourseModule oopModule = new CourseModule("Java OOP Foundations");
        oopModule.addLesson(new VideoLesson("Encapsulation", 18));
        oopModule.addLesson(new QuizLesson("OOP Basics Quiz", 5));
        lldCourse.addModule(oopModule);

        Department engineering = new Department("Engineering");
        engineering.addInstructor(instructor);
        engineering.addCourse(lldCourse);

        lldCourse.enroll(student);

        System.out.println("=== Abstraction + Polymorphism ===");
        for (Lesson lesson : lldCourse.getAllLessons()) {
            System.out.println(lesson.summary());
            lesson.deliver();
        }

        System.out.println();
        System.out.println("=== Inheritance + Polymorphism ===");
        List<Person> people = List.of(instructor, student);
        for (Person person : people) {
            System.out.println(person.getDisplayName() + " -> " + person.role());
        }

        System.out.println();
        System.out.println("=== Relationships ===");
        System.out.println("Association: course has instructor -> " + lldCourse.getInstructor().getDisplayName());
        System.out.println("Aggregation: department has courses -> " + engineering.getCourses().size());
        System.out.println("Composition: course owns modules -> " + lldCourse.getModules().size());

        System.out.println();
        System.out.println("=== Encapsulation ===");
        System.out.println(student.getDisplayName() + " enrolled courses: " + student.getEnrolledCourseCodes());
    }
}
