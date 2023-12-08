package pairmatching.model.constant;

import pairmatching.exception.CustomException;

import static pairmatching.exception.ErrorMessage.ERROR_INPUT;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourse(String name) {
        for (Course course : Course.values()) {
            if (course.name().equals(name)) {
                return course;
            }
        }
        throw CustomException.errorMessage(ERROR_INPUT);
    }
}