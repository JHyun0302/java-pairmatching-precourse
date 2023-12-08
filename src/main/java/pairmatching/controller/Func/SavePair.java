package pairmatching.controller.Func;

import pairmatching.dto.request.PairRequest;
import pairmatching.model.Pairs;
import pairmatching.service.MatchingService;
import pairmatching.view.PairRequestView;
import pairmatching.view.PairResponseView;
import pairmatching.view.ReMatchRequestView;

public class SavePair implements Func {
    private final MatchingService matchingService;

    public SavePair(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @Override
    public boolean process() {
        PairRequest matchingRequest = getMatchingRequest();
        Pairs pairs = matchingService.generateMatching(
                matchingRequest.getCourse(),
                matchingRequest.getMission()
        );
        PairResponseView.response(pairs);
        return true;
    }

    private PairRequest getMatchingRequest() {
        while (true) {
            PairRequest pairRequest = PairRequestView.request();
            if (matchingService.hasNoPairs(pairRequest.getMission())) {
                return pairRequest;
            }

            boolean rematch = ReMatchRequestView.request();
            if (rematch) {
                return pairRequest;
            }
        }
    }
}