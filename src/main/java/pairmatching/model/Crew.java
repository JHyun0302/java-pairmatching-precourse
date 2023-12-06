package pairmatching.model;

import pairmatching.model.constant.Course;

public class Crew {
    private Course course;
    private String name;

    private Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static Crew createCrew(Course course, String name) {
        return new Crew(course, name);
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
