package pairmatching.repository;

import java.util.List;
import pairmatching.domain.Pairs;

public class PairsRepository {
    private List<Pairs> allPairs;

    public void save(Pairs pairs) {
        allPairs.add(pairs);
    }

    public List<Pairs> findAll() {
        return allPairs;
    }
}
