package pairmatching.controller;

import java.util.List;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatcherController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = requireInput();
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

    private String requireInput() {
        outputView.printPrompt();
        return inputView.readInput();
    }
}