package pairmatching.controller;

import pairmatching.service.CrewService;
import pairmatching.service.Func.FindProcess;
import pairmatching.service.Func.Func;
import pairmatching.view.output.OutputView;

public class PairController {
    private final CrewService crewService;
    private final Func func;

    public PairController(CrewService crewService, Func func) {
        this.crewService = crewService;
        this.func = func;
    }

    public void run() {
        OutputView.printSelectFunc();
        
        FindProcess.getFunction()
    }
}
