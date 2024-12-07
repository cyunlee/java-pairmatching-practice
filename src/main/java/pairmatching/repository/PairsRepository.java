package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class PairsRepository {
    private List<Pairs> allPairs = new ArrayList<>();

    public void save(Pairs pairs) {
        allPairs.add(pairs);
    }

    public Pairs resave(List<String> matchingChoiceInfo, Pairs pairs) {
        Course course = Course.findCourse(matchingChoiceInfo.get(0));
        Level level = Level.findLevel(matchingChoiceInfo.get(1));
        Mission mission = Mission.findMission(matchingChoiceInfo.get(2));
        for (Pairs allPair : allPairs) {
            if (allPair.isMatchedPairsExist(course, level, mission)) {
                allPair.makeInsteadOf(pairs);
            }
        }
        return pairs;
    }

    public Pairs findOne(Course course, Level level, Mission mission) {
        for (Pairs allPair : allPairs) {
            if (allPair.isMatchedPairsExist(course, level, mission)) {
                return allPair;
            }
        }
        return null;
    }

    public void reset() {
        allPairs = new ArrayList<>();
    }

    public List<Pairs> findAll() {
        return allPairs;
    }
}
