package pairmatching.validation;

import java.util.List;
import pairmatching.exception.ErrorInputException;
import pairmatching.exception.ErrorInputException.ErrorMessage;

public class ReadDataValidation {
    public static List<String> isBlank(List<String> input) {
        if (input == null || input.isEmpty()) {
            throw new ErrorInputException(ErrorMessage.CANNOT_BE_NULL_OR_EMPTY);
        }
        return input;
    }
}
