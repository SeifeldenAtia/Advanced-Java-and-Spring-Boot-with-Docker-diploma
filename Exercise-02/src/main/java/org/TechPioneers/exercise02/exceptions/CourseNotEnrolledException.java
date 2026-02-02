package org.TechPioneers.exercise02.exceptions;

public class CourseNotEnrolledException extends RuntimeException {
    public CourseNotEnrolledException()
    {
        super();
    }

    public CourseNotEnrolledException(String courseId, String studentId)
    {
        super("Course: " + courseId + " is not enrolled by student: " + studentId);
    }
}
