package pairmatching.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public boolean parseMatchingAgainResponse(String input) {
        if (input.equals("네")) {
            return true;
        }
        return false;
    }

    public List<String> parseMatchingInfo(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
    }

}
