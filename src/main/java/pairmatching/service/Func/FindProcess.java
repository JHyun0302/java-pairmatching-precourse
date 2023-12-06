package pairmatching.service.Func;

import pairmatching.model.Crews;

public abstract class FindProcess {
    public static Func getFunction(String function, MissionInfo mission, Crews crews) {
        if (function.equals("1")) {
            return new PairMatching();
        } else if (function.equals("2")) {
            return new SearchingPair();
        } else if (function.equals("3")) {
            return new InitPair();
        }
        return new DefaultPair();
    }
}
