package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.InputValidator;
import pairmatching.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public int readFunction() {
        String input = Console.readLine();
        return input;
    }

    public List<String> readPairMatchingInfo() {
        String input = Console.readLine();
        return input;
    }

    public boolean readMatchingAgainResponse() {
        String input = Console.readLine();
        return input;
    }

}