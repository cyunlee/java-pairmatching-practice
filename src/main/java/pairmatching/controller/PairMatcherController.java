package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatcherController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String input = requireInput();
    }

    private String requireInput() {
        outputView.printPrompt();
        return inputView.readInput();
    }
}