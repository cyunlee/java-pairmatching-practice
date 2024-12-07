package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PairMatcher {

    public Pairs matchPairs(List<String> crewsNames) {
        List<String> shuffledCrew = Randoms.shuffle(crewsNames);
        Pairs pairs = new Pairs();

        for (int i=0; i<shuffledCrew.size(); i+=2) {
            Pair matchedPair = new Pair();
            matchedPair.addCrew(shuffledCrew.get(i));
            matchedPair.addCrew(shuffledCrew.get(i+1));
            pairs.addPair(matchedPair);
        }

        return pairs;
    }
}
