package pairmatching.controller;

import pairmatching.model.Crews;
import pairmatching.service.CrewService;

public class InitCrewController {
    private final CrewService crewService;

    public InitCrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    public Crews initCrews() {
        return crewService.initCrews();
    }
}
