package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.CrewGenerator;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatcher;
import pairmatching.domain.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatcherController {
    private final CrewGenerator crewGenerator = new CrewGenerator();
    private final PairMatcher pairMatcher = new PairMatcher();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Crews frontendCrews = parseCrewsFromFile(Course.FRONTEND, "src/main/resources/frontend-crew.md");
        Crews backendCrews = parseCrewsFromFile(Course.BACKEND, "src/main/resources/backend-crew.md");
        List<String> frontendCrewsNames = parseCrewsNames(frontendCrews);
        List<String> backendCrewsNames = parseCrewsNames(backendCrews);
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
            List<String> matchingChoiceInfo = requirePairMatchingChoice();
            Course course = matchingChoiceInfo.get(0);
            Level level = matchingChoiceInfo.get(1);
            Mission mission = matchingChoiceInfo.get(2);
        }
        if (functionInput.equals("2")) {
            showPairMatchingInfo();
            List<String> matchingChoiceInfo = requirePairMatchingChoice();
            showPairMatchingResult();
        }
        if (functionInput.equals("3")) {
            showPairMatchingReset();
        }
        if (functionInput.equals("Q")) {

        }
    }

    private Pairs matchPairs(List<String> crewsNames, Course course, Mission mission) {
        return pairMatcher.matchPairs(crewsNames, course, mission);
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

    private void showPairMatchingResult() {
        outputView.printMatchResult();
    }
}