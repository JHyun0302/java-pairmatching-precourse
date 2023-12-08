package pairmatching.controller.Func;

import java.util.function.Supplier;
import pairmatching.model.Pairs;
import pairmatching.service.MatchingService;
import pairmatching.view.PairRequestView;
import pairmatching.view.PairResponseView;
import pairmatching.view.console.ConsoleWriter;

public class SearchPair implements Func {
    private final MatchingService matchingService;

    public SearchPair(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @Override
    public boolean process() {
        Pairs pairs = retry(() -> {
            return matchingService.getPairs(
                    PairRequestView.request().getMission()
            );
        });
        PairResponseView.response(pairs);
        return true;
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
