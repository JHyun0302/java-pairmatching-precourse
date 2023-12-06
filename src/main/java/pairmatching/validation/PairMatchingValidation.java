package pairmatching.validation;

import static pairmatching.exception.ErrorInputException.ErrorMessage.ERROR_INPUT;

import java.util.Arrays;
import java.util.List;
import pairmatching.exception.ErrorInputException;

public class PairMatchingValidation extends CommonValidation {
    public static void checkCommaError(String input) {
        if (input.contains(",,")) {
            throw new ErrorInputException(ERROR_INPUT);
        }
        if (input.charAt(input.length() - 1) == ',' || input.charAt(0) == ',') {
            throw new ErrorInputException(ERROR_INPUT);
        }
    }

    public static void checkErrorInput(String input) {
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(input.length() - 1);

        if (!Character.isLetter(firstChar) || !Character.isLetter(lastChar)) {
            throw new ErrorInputException(ERROR_INPUT);
        }

        if (!startsWithKorean(firstChar) && lastChar != ' ' || !startsWithKorean(lastChar)) {
            throw new ErrorInputException(ERROR_INPUT);
        }
    }


    public static List<String> makePairMatchingInfo(String input) {
        List<String> pairMatchingInfos = Arrays.asList(input.split(", "));
        if (pairMatchingInfos.size() != 3) {
            throw new ErrorInputException(ERROR_INPUT);
        }
        return pairMatchingInfos;
    }

    private static boolean startsWithKorean(char c) {
        return (c >= '가' && c <= '힣');
    }


}
