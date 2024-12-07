package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<String> names = new ArrayList<>();
    private Course course;
    private Mission mission;

    public Pair(List<String> names, Course course, Mission mission) {
        this.names = names;
        this.course = course;
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
