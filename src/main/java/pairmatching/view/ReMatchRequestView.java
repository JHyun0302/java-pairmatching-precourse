package pairmatching.view;

import static pairmatching.exception.ErrorMessage.INVALID_REMATCH_REQUEST;

import pairmatching.exception.CustomException;
import pairmatching.view.console.ConsoleReader;
import pairmatching.view.console.ConsoleWriter;

public class ReMatchRequestView {
    private static final String NOTICE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String EXAMPLE_RESPONSE = "네 | 아니오";
    private static final String YES = "네";
    private static final String NO = "아니오";

    public static boolean request() {
        ConsoleWriter.println();
        ConsoleWriter.printlnMessage(NOTICE);
        ConsoleWriter.printlnMessage(EXAMPLE_RESPONSE);
        return validate(ConsoleReader.enterMessage());
    }

    private static boolean validate(String input) {
        if (input.equals(YES)) {
            return true;
        }
        if (input.equals(NO)) {
            return false;
        }
        throw CustomException.errorMessage(INVALID_REMATCH_REQUEST);
    }
}
