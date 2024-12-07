package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PairMatcher {
    private final List<String> frontendCrewsNames;
    private final List<String> backendCrewsNames;

    public PairMatcher(List<String> frontendCrewsNames, List<String> backendCrewsNames) {
        this.frontendCrewsNames = frontendCrewsNames;
        this.backendCrewsNames = backendCrewsNames;
    }

    public Pairs matchPairs(Course course, Level level, Mission mission) {
        List<String> crewsNames = new ArrayList<>();
        if (course.isCourseFrontend()) {
            crewsNames = frontendCrewsNames;
        }
        if (course.isCourseBackend()) {
            crewsNames = backendCrewsNames;
        }
        List<String> shuffledCrew = Randoms.shuffle(crewsNames);
        Pairs pairs = new Pairs();

        for (int i=0; i<shuffledCrew.size(); i+=2) {
            List<String> names = new ArrayList<>();
            names.add(shuffledCrew.get(i));
            names.add(shuffledCrew.get(i+1));
            Pair pair = new Pair(names, course, mission);
            pairs.addPair(pair);
        }

        if(crewsNames.size()%2!=0) {
            String lastCrewName = crewsNames.get(crewsNames.size()-1);
            pairs.getLastPair().addPair(lastCrewName);
        }

        return pairs;
    }
}
