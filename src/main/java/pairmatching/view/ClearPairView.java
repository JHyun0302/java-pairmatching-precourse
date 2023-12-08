package pairmatching.view;

import pairmatching.view.console.ConsoleWriter;

public class ClearPairView {

    private static final String INIT = "초기화 되었습니다.";

    public static void response() {
        ConsoleWriter.println();
        ConsoleWriter.printlnFormat(INIT);
    }
}
