package pairmatching.controller.Func;


import pairmatching.service.MatchingService;
import pairmatching.view.ClearPairView;

public class ClearPair implements Func {
    private final MatchingService matchingService;

    public ClearPair(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @Override
    public boolean process() {
        matchingService.clear();
        ClearPairView.response();
        return true;
    }
}
