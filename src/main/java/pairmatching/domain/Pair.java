package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> names = new ArrayList<>();
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
        return String.join(" : ", names);
    }
}
