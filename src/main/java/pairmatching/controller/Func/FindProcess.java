package pairmatching.controller.Func;

import pairmatching.service.MatchingService;

public abstract class FindProcess {
    public static Func getFunction(String function, MatchingService matchingService) {
        if (function.equals("1")) {
            return new SavePair(matchingService);
        } else if (function.equals("2")) {
            return new SearchPair(matchingService);
        } else if (function.equals("3")) {
            return new ClearPair(matchingService);
        } else if (function.equals("Q")) {
            return new DefaultPair();
        }
        return new ErrorInput();
    }
}
