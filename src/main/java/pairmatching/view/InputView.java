package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.InputValidator;
import pairmatching.util.InputParser;

public class InputView {
    private final InputParser inputParser = new InputParser();
    private final InputValidator inputValidator = new InputValidator();

//    public String readInput() {
//        try{
//            String input = Console.readLine();
//            inputValidator.validateInput(input);
//            return inputParser.parseInput(input);
//        }catch(IllegalArgumentException exception) {
//            OutputView.printError(exception.getMessage());
//            return readInput();
//        }
//    }
}