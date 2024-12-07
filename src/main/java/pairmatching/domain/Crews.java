package pairmatching.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Crews implements Iterable<Crew> {
    private List<Crew> crews = new ArrayList<>();

    public List<Crew> addCrew(Crew crew) {
        crews.add(crew);
        return crews;
    }

    @Override
    public Iterator<Crew> iterator() {
        return crews.iterator();
    }
}
