package pairmatching.model;

import pairmatching.model.constant.Mission;

import java.util.Map;

public class MatchingInfo {
    private final Map<Mission, Pairs> matchingInfo;

    public MatchingInfo(Map<Mission, Pairs> matchingInfo) {
        this.matchingInfo = matchingInfo;
    }


}
