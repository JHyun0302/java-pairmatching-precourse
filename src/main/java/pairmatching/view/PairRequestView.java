package pairmatching.view;

import pairmatching.dto.request.PairRequest;
import pairmatching.exception.CustomException;
import pairmatching.model.constant.Course;
import pairmatching.model.constant.Level;
import pairmatching.model.constant.Mission;
import pairmatching.view.console.ConsoleReader;
import pairmatching.view.console.ConsoleWriter;

import java.util.Arrays;
import java.util.List;

import static pairmatching.exception.ErrorMessage.ERROR_INPUT;

public class PairRequestView {
    private static final String REQUEST_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
    private static final String REQUEST_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String NOTICE = ""
            + "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################";
    private static final String DIVISOR = ",";

    public static PairRequest request() {
        ConsoleWriter.printlnMessage(NOTICE);
        ConsoleWriter.printlnMessage(REQUEST_MESSAGE);
        ConsoleWriter.printlnMessage(REQUEST_MESSAGE);

        return validate(ConsoleReader.enterMessage());
    }

    private static PairRequest validate(String input) {
        checkCommaError(input);
        checkErrorInput(input);
        List<String> pairMatchingInfo = makePairMatchingInfo(input);
        return PairRequest.createPairRequest(Course.getCourse(pairMatchingInfo.get(0)),
                Level.getLevel(pairMatchingInfo.get(1)),
                Mission.getMission(pairMatchingInfo.get(2)));
    }

    private static void checkCommaError(String input) {
        if (input.contains(",,")) {
            throw CustomException.errorMessage(ERROR_INPUT);
        }
        if (input.charAt(input.length() - 1) == ',' || input.charAt(0) == ',') {
            throw CustomException.errorMessage(ERROR_INPUT);
        }
    }

    private static void checkErrorInput(String input) {
        char firstChar = input.charAt(0);
        char lastChar = input.charAt(input.length() - 1);

        if (!Character.isLetter(firstChar) || !Character.isLetter(lastChar)) {
            throw CustomException.errorMessage(ERROR_INPUT);
        }

        if (!startsWithKorean(firstChar) && lastChar != ' ' || !startsWithKorean(lastChar)) {
            throw CustomException.errorMessage(ERROR_INPUT);
        }
    }


    private static List<String> makePairMatchingInfo(String input) {
        List<String> pairMatchingInfos = Arrays.asList(input.split(", "));
        if (pairMatchingInfos.size() != 3) {
            throw CustomException.errorMessage(ERROR_INPUT);
        }
        return pairMatchingInfos;
    }

    private static boolean startsWithKorean(char c) {
        return (c >= '가' && c <= '힣');
    }
}
