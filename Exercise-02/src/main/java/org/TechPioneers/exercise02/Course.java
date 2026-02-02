package org.TechPioneers.exercise02;

import java.util.Objects;

public class Course {
    private String name;
    private final String id;
    private String trainer;

    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTrainer() {
        return trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
