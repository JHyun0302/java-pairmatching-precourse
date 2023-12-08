package pairmatching.controller;

import pairmatching.controller.Func.FindProcess;
import pairmatching.controller.Func.Func;
import pairmatching.model.Function;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;
import pairmatching.view.FunctionRequestView;

public class PairController {
    private final CrewService crewService;
    private final MatchingService matchingService;

    public PairController(CrewService crewService, MatchingService matchingService) {
        this.crewService = crewService;
        this.matchingService = matchingService;
    }

    public void run() {
        while (true) {
            Function input = FunctionRequestView.request();
            Func func = FindProcess.getFunction(input.getFunction(), matchingService);

            boolean process = func.process();
            if (!process) {
                break;
            }
        }


    }
}
