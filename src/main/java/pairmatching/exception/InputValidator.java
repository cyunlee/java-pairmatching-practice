package pairmatching.exception;

import java.util.regex.Pattern;

public class InputValidator {
    private final static String INPUT_INVALID_ERROR = "입력 값은 빈 값이 될 수 없습니다. 다시 입력해주세요.";
    private final static String INPUT_RANGE_INVALID_ERROR = "입력 값은 숫자만 될 수 있습니다. 다시 입력해주세요.";

    public void validateInput(String input) {
        checkIsInputValid(input);
    }

    public void validateInputNumber(String input) {
        checkisInputNumber(input);
    }

    private void checkIsInputValid(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_INVALID_ERROR);
        }
    }

    private void checkisInputNumber(String input) {
        String regex = "^\\d+$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(INPUT_INVALID_ERROR);
        }
    }
}
