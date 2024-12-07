package pairmatching.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pairs implements Iterable<Pair> {
    private List<Pair> pairs = new ArrayList<>();
    private Course course;
    private Level level;
    private Mission mission;

    public Pairs(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public List<Pair> addPair(Pair pair) {
        pairs.add(pair);
        return pairs;
    }

    public Pair getLastPair() {
        return pairs.get(pairs.size()-1);
    }

    @Override
    public Iterator<Pair> iterator() {
        return pairs.iterator();
    }
}
