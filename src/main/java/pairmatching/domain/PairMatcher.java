package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PairMatcher {

    public Pairs matchPairs(List<String> crewsNames, Course course, Mission mission) {
        List<String> shuffledCrew = Randoms.shuffle(crewsNames);
        Pairs pairs = new Pairs();

        for (int i=0; i<shuffledCrew.size(); i+=2) {
            List<String> names = new ArrayList<>();
            names.add(shuffledCrew.get(i));
            names.add(shuffledCrew.get(i+1));
            Pair pair = new Pair(names, course, mission);
        }

        if(crewsNames.size()%2!=0) {
            String lastCrewName = crewsNames.get(crewsNames.size()-1);
            pairs.getLastPair().addCrew(lastCrewName);
        }

        return pairs;
    }
}
