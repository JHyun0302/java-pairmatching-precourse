package pairmatching.service.Func;

import pairmatching.model.Crews;

public class DefaultPair implements Func {

    @Override
    public boolean process(MissionInfo mission, Crews crews) {
        return true;
    }
}
