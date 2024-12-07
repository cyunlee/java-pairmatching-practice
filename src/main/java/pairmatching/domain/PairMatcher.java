package pairmatching.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PairMatcher {
    private List<String> frontendCrewsNames;
    private List<String> backendCrewsNames;

    public PairMatcher(List<String> frontendCrewsNames, List<String> backendCrewsNames) {
        this.frontendCrewsNames = frontendCrewsNames;
        this.backendCrewsNames = backendCrewsNames;
    }
}
