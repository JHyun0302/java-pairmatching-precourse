package pairmatching.validation;

import pairmatching.exception.ErrorInputException;
import pairmatching.exception.ErrorInputException.ErrorMessage;

public class CommonValidation {
    public static String isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new ErrorInputException(ErrorMessage.CANNOT_BE_NULL_OR_EMPTY);
        }
        return input;
    }
}
