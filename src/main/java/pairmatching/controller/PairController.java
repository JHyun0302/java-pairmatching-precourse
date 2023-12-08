package pairmatching.controller;

import pairmatching.service.CrewService;
import pairmatching.service.Func.Func;

public class PairController {
    private final CrewService crewService;
    private final Func func;

    public PairController(CrewService crewService, Func func) {
        this.crewService = crewService;
        this.func = func;
    }

    public void run() {

    }
}
