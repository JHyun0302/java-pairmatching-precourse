package pairmatching.model.constant;

import static pairmatching.exception.ErrorInputException.ErrorMessage.ERROR_INPUT;

import pairmatching.exception.ErrorInputException;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course getCourse(String name) {
        for (Course course : Course.values()) {
            if (course.name().equals(name)) {
                return course;
            }
        }
        throw new ErrorInputException(ERROR_INPUT);
    }
}