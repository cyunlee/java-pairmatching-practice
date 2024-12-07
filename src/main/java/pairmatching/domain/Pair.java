package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> names;
    private Course course;
    private Level level;
    private Mission mission;

    public Pair(List<String> names, Course course, Level level, Mission mission) {
        this.names = names;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public void addPair(String name) {
        names.add(name);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String name : names) {
            result.append(" : ").append(name);
        }
        return String.valueOf(result);
    }
}
