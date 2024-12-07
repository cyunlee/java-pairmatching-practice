package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void makeInsteadOf(Pairs pairs) {
        this.pairs = new ArrayList<>();
        for (Pair pair : pairs) {
            this.pairs.add(pair);
        }
    }

    public boolean isMatchedPairsExist(Course course, Level level, Mission mission) {
        if (this.course == course && this.level == level && this.mission == mission) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Pair> iterator() {
        return pairs.iterator();
    }
}
