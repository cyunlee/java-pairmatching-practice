package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.exception.InputValidator;
import pairmatching.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

    public String readFunction() {
        return Console.readLine();
    }

    public List<String> readPairMatchingChoice() {
        String input = Console.readLine();
        return inputParser.parseMatchingInfo(input);
    }

    public boolean readMatchingAgainResponse() {
        String input = Console.readLine();
        return inputParser.parseMatchingAgainResponse(input);
    }

}