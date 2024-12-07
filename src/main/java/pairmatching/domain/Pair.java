package pairmatching.domain;

import java.util.List;

public class Pair {
    private List<String> pair;

    public void addCrew(String name) {
        pair.add(name);
    }

    public List<String> getPair() {
        return pair;
    }
}
