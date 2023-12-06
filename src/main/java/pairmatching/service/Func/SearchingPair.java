package pairmatching.service.Func;

import pairmatching.model.Crews;
import pairmatching.repository.PairRepository;

public class SearchingPair implements Func {

    @Override
    public boolean process(MissionInfo mission, Crews crews) {
        PairRepository.pairs();
        return true;
    }
}
