package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findCourse(String name) {
        return Arrays.stream(values()).filter(value -> value.name.equals(name)).findAny().orElse(null);
    }

    public boolean isCourseBackend() {
        if (name.equals("백엔드")) {
            return true;
        }
        return false;
    }

    public boolean isCourseFrontend() {
        if (name.equals("프론트엔드")) {
            return true;
        }
        return false;
    }


}
