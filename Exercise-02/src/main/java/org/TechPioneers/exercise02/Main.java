package org.TechPioneers.exercise02;


import org.TechPioneers.exercise02.exceptions.CourseNotEnrolledException;
import org.TechPioneers.exercise02.exceptions.StudentNotFoundException;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        TrainingSystem system = new TrainingSystem();

        Student ahmed = new Student("Ahmed", "S1");
        Student sara  = new Student("Sara", "S2");

        Course java = new Course("Java", "C1");
        Course db   = new Course("Database", "C2");
        Course docker = new Course("Docker", "C3");

        // ===== Test 1: Subscribe students =====
        system.subscribe(ahmed, java);
        system.subscribe(ahmed, db);
        system.subscribe(sara, java);

        System.out.println("Test 1 passed: students subscribed successfully");

        // ===== Test 2: Retrieve courses for a student =====
        Set<Course> ahmedCourses = system.retrieveCoursesForStudent(ahmed);
        System.out.println("Ahmed courses count = " + ahmedCourses.size());
        // Expected: 2

        // ===== Test 3: Retrieve student(s) with most courses =====
        Set<Student> topStudents = system.retrieveStudentsWithMostCourses();
        System.out.println("Students with most courses:");
        topStudents.forEach(System.out::println);
        // Expected: Ahmed

        // ===== Test 4: Unsubscribe course =====
        system.unsubscribe(ahmed, db);
        System.out.println("Test 4 passed: course unsubscribed");

        // ===== Test 5: Unsubscribe non-enrolled course (exception) =====
        try {
            system.unsubscribe(ahmed, docker);
        } catch (CourseNotEnrolledException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        }

        // ===== Test 6: Retrieve courses for non-existing student =====
        try {
            system.retrieveCoursesForStudent(new Student("Ghost", "X1"));
        } catch (StudentNotFoundException e) {
            System.out.println("Expected exception caught: " + e.getMessage());
        }

        // ===== Test 7: Tie case for most courses =====
        system.subscribe(sara, db);

        Set<Student> tiedStudents = system.retrieveStudentsWithMostCourses();
        System.out.println("Students with most courses (tie case):");
        tiedStudents.forEach(System.out::println);
        // Expected: Ahmed and Sara

        System.out.println("All manual tests executed successfully.");

        system.subscribe(ahmed, db);
        System.out.println("Sara courses count = " + system.retrieveCoursesForStudent(sara).size());
        System.out.println("Ahmed courses count = " + ahmedCourses.size());

        Set<Student> equalityTest = system.retrieveStudentsWithMostCourses();
        System.out.println("Students with most courses (equalityTest case):");
        equalityTest.forEach(System.out::println);


    }
}