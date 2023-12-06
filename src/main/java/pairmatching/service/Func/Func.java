package pairmatching.service.Func;

import pairmatching.model.Crews;

public interface Func {
    boolean process(MissionInfo mission, Crews crews);
}