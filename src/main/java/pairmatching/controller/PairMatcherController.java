package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.CrewGenerator;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatcher;
import pairmatching.domain.Pairs;
import pairmatching.repository.PairsRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatcherController {
    private final CrewGenerator crewGenerator = new CrewGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private PairMatcher pairMatcher;
    private final PairsRepository pairsRepository = new PairsRepository();

    public void run() {
        Crews frontendCrews = parseCrewsFromFile(Course.FRONTEND, "src/main/resources/frontend-crew.md");
        Crews backendCrews = parseCrewsFromFile(Course.BACKEND, "src/main/resources/backend-crew.md");
        List<String> frontendCrewsNames = parseCrewsNames(frontendCrews);
        List<String> backendCrewsNames = parseCrewsNames(backendCrews);
        pairMatcher = new PairMatcher(frontendCrewsNames, backendCrewsNames);
        chooseFunction();
    }

    private Crews parseCrewsFromFile(Course course, String filePath) {
        List<String> names = crewGenerator.parseNamesFromFile(filePath);
        return crewGenerator.generateCrew(course, names);
    }

    private List<String> parseCrewsNames(Crews crews) {
        return crews.parseCrewsNames();
    }

    private void chooseFunction() {
        String functionInput = requireFunction();
        if (functionInput.equals("1")) {
            showPairMatchingInfo();
            processPairMatching();
            chooseFunction();
        }
        if (functionInput.equals("2")) {
            showPairMatchingInfo();
            processSearchPair();
            chooseFunction();
        }
        if (functionInput.equals("3")) {
            showPairMatchingReset();
            processReset();
            chooseFunction();
        }
        if (functionInput.equals("Q")) {
            return;
        }
    }

    private void processPairMatching() {
        List<String> matchingChoiceInfo = requirePairMatchingChoice();
        boolean response = false;
        if (isMatchedPairsExist(matchingChoiceInfo)) {
            response = requirePairMatchingAgainResponse();
            if (response) { //다시 매칭하기
                Pairs newPairs = matchPairs(matchingChoiceInfo);
                pairsRepository.resave(matchingChoiceInfo, newPairs);
                showPairMatchingResult(newPairs);
            }
            if (!response) {
                processPairMatching();
            }
        }
        if (!isMatchedPairsExist(matchingChoiceInfo)) {
            Pairs pairs = matchPairs(matchingChoiceInfo);
            for (Pair pair : pairs) {
                System.out.println(pair.toString());
            }
            pairsRepository.save(pairs);
            showPairMatchingResult(pairs);
        }
    }

    private void processSearchPair() {
        try {
            List<String> matchingChoiceInfo = requirePairMatchingChoice();
            Course course = Course.findCourse(matchingChoiceInfo.get(0));
            Level level = Level.findLevel(matchingChoiceInfo.get(1));
            Mission mission = Mission.findMission(matchingChoiceInfo.get(2));
            Pairs foundPairs = pairsRepository.findOne(course, level, mission);
            if (foundPairs != null) {
                showPairMatchingResult(foundPairs);
            }
            if (foundPairs == null) {
                throw(new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다."));
            }
        }catch(IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            processPairMatching();
        }
    }

    private void processReset() {
        pairsRepository.reset();
    }

    private Pairs matchPairs(List<String> matchingChoiceInfo) {
        try {
            Course course = Course.findCourse(matchingChoiceInfo.get(0));
            Level level = Level.findLevel(matchingChoiceInfo.get(1));
            Mission.isMissionExist(matchingChoiceInfo.get(2));
            Mission mission = Mission.findMission(matchingChoiceInfo.get(2));

            Pairs pairs = pairMatcher.matchPairs(course, level, mission);
            return pairs;
        }catch(IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            List<String> newMatchingChoiceInfo = requirePairMatchingChoice();
            return matchPairs(newMatchingChoiceInfo);
        }

    }

    private boolean isMatchedPairsExist(List<String> matchingChoiceInfo) {
        Course course = Course.findCourse(matchingChoiceInfo.get(0));
        Level level = Level.findLevel(matchingChoiceInfo.get(1));
        Mission mission = Mission.findMission(matchingChoiceInfo.get(2));

        Pairs foundPairs = pairsRepository.findOne(course, level, mission);
        if (foundPairs != null) {
            return true;
        }
        return false;
    }


    private String requireFunction() {
        outputView.printFunctionChoicePrompt();
        return inputView.readFunction();
    }

    private void showPairMatchingInfo() {
        outputView.printPairMatchingInfoPrompt();
    }

    private List<String> requirePairMatchingChoice() {
        outputView.printPairMatchingChoicePrompt();
        return inputView.readPairMatchingChoice();
    }

    private boolean requirePairMatchingAgainResponse() {
        outputView.printPairMatchingExistPrompt();
        return inputView.readMatchingAgainResponse();
    }

    private void showPairMatchingReset() {
        outputView.printResetPrompt();
    }

    private void showPairMatchingResult(Pairs pairs) {
        outputView.printMatchResult(pairs);
    }
}