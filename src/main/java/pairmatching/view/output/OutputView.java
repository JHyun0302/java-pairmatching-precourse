package pairmatching.view.output;

import static pairmatching.constant.Function.INIT_PAIR;
import static pairmatching.constant.Function.PAIR_MATCHING;
import static pairmatching.constant.Function.PLZ_INPUT_FUNCTION;
import static pairmatching.constant.Function.QUIT;
import static pairmatching.constant.Function.SEARCHING_PAIR;
import static pairmatching.constant.PrintOutMessage.PAIR_MATCHING_RESULT;
import static pairmatching.constant.SelectProcess.DECO;
import static pairmatching.constant.SelectProcess.INFO_MISSION;
import static pairmatching.constant.SelectProcess.INFO_PROCESS;
import static pairmatching.constant.SelectProcess.INPUT_EXAMPLE;
import static pairmatching.constant.SelectProcess.PLZ_INPUT_PROCESS;

public class OutputView {
    public static void printSelectFunc() {
        System.out.println(PLZ_INPUT_FUNCTION.message);
        System.out.println(PAIR_MATCHING.message);
        System.out.println(SEARCHING_PAIR.message);
        System.out.println(INIT_PAIR.message);
        System.out.println(QUIT.message);
    }

    public static void printSelectProcess() {
        System.out.println(DECO.message);
        System.out.println(INFO_PROCESS.message);
        System.out.println(INFO_MISSION.message);
        System.out.println(DECO.message);
        System.out.println(PLZ_INPUT_PROCESS.message);
        System.out.println(INPUT_EXAMPLE.message);
    }

    public static void printResult() {
        System.out.println(PAIR_MATCHING_RESULT.message);
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
