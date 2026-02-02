package org.TechPioneers.exercise02.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String studentId) {
        super("Student with id: " + studentId + " doesn't exist in the system");
    }
}
