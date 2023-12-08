package pairmatching.view;

import pairmatching.model.Function;
import pairmatching.view.console.ConsoleReader;
import pairmatching.view.console.ConsoleWriter;


public class FunctionRequest {
    private static final String NOTICE = "기능을 선택하세요.";
    private static final String RESPONSE =
            "1. 페어 매칭\n"
                    + "2. 페어 조회\n"
                    + "3. 페어 초기화\n"
                    + "Q. 종료";


    public static Function request() {
        ConsoleWriter.printlnMessage(NOTICE);
        ConsoleWriter.printlnMessage(RESPONSE);
        return Function.createFunction(ConsoleReader.enterMessage());
    }
}
