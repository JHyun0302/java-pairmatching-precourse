package pairmatching.view.console;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.CustomException;

import static pairmatching.exception.ErrorMessage.CANNOT_BE_NULL_OR_EMPTY;

public final class ConsoleReader {
    public static String enterMessage() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        public static String validate(String message) {
            return isBlank(message);
        }

        private static String isBlank(String input) {
            if (input == null || input.isEmpty()) {
                throw CustomException.errorMessage(CANNOT_BE_NULL_OR_EMPTY);
            }
            return input;
        }
    }
}
