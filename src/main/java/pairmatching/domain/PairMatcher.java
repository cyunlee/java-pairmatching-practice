package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PairMatcher {

    public void matchPairs(List<String> crewsNames) {
        List<String> matchedPairs = new ArrayList<>();
        List<String> shuffledCrew = Randoms.shuffle(crewsNames);
        for (int i=0; i<shuffledCrew.size(); i++) {
            matchedPairs.add(shuffledCrew.get(i))
        }
    }
}
