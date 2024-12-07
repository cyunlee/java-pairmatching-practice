package pairmatching.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pairs implements Iterable<Pair> {
    private List<Pair> pairs = new ArrayList<>();

    public Pairs() {

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
