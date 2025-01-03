package pairmatching.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Crews implements Iterable<Crew> {
    private List<Crew> crews = new ArrayList<>();

    public Crews() {

    }

    public List<Crew> addCrew(Crew crew) {
        crews.add(crew);
        return crews;
    }

    public int size() {
        return crews.size();
    }

    public List<String> parseCrewsNames() {
        return crews.stream().map(Crew::getName).collect(Collectors.toList());
    }

    public Crew findCrew(String name) {
        for (Crew crew : crews) {
            if (name.equals(crew.getName())) {
                return crew;
            }
        }
        return null;
    }

    @Override
    public Iterator<Crew> iterator() {
        return crews.iterator();
    }
}
