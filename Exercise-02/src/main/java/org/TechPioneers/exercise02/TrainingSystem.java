package org.TechPioneers.exercise02;

import org.TechPioneers.exercise02.exceptions.CourseNotEnrolledException;
import org.TechPioneers.exercise02.exceptions.StudentNotFoundException;
import java.util.*;

public class TrainingSystem {

    private Map<Student , Set<Course>> enrollments  ;

    public TrainingSystem() {
        enrollments = new HashMap<>();
    }

    public TrainingSystem(Map<Student, Set<Course>> enrollments) {
        this.enrollments = new HashMap<>(enrollments);
    }

    public void addStudent(Student student) {
        enrollments.putIfAbsent(student, new HashSet<>());
    }

    public Set<Course> retrieveCoursesForStudent (Student student) {
        if (!enrollments.containsKey(student)) {
            throw new StudentNotFoundException(student.getId());
        }

        return enrollments.get(student);
    }

    public void subscribe (Student student , Course course) {
        if (!enrollments.containsKey(student) ) {
            addStudent(student);
        }
        enrollments.get(student).add(course);
    }

    public void unsubscribe (Student student , Course course)  {
        if (!enrollments.containsKey(student))
        {
            throw new StudentNotFoundException(student.getId());
        }

        if (!enrollments.get(student).remove(course)) {
            throw new CourseNotEnrolledException( course.getId(), student.getId() );
        }

    }

    public Set<Student> retrieveStudentsWithMostCourses() {

        int max = 0;
        for(Set<Course> coursesPerStudent : enrollments.values()) {
            max = ( coursesPerStudent.size() > max ) ? coursesPerStudent.size() : max ;
        }

        Set<Student> result = new HashSet<>();
        for (Student student : enrollments.keySet()) {
            if (enrollments.get(student).size() == max) {
                result.add(student);
            }
        }

        return result;
    }

}
