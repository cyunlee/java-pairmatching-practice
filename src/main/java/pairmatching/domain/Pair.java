package pairmatching.domain;

import java.util.List;

public class Pair {
    private Crews onePair;

    public Pair(Crews crews, List<String> names) {
        onePair = new Crews();
        for (String name : names) {
            Crew crew = crews.findCrew(name);
            onePair.addCrew(crew);
        }
    }

    public Crews getPair() {
        return onePair;
    }
}
