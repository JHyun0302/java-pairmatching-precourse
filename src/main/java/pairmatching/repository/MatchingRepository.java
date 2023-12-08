package pairmatching.repository;

import static pairmatching.exception.ErrorMessage.NO_MATCHING_HISTORY;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import pairmatching.exception.CustomException;
import pairmatching.model.Pairs;
import pairmatching.model.constant.Mission;

public class MatchingRepository {
    private final Map<Mission, Pairs> matchingInfo;

    public MatchingRepository() {
        this.matchingInfo = new EnumMap<>(Mission.class);
    }

    /**
     * save Pair
     */
    public void save(Mission mission, Pairs pairs) {
        matchingInfo.put(mission, pairs);
    }

    /**
     * get Pair
     */
    public Pairs getPairs(Mission mission) {
        if (matchingInfo.containsKey(mission)) {
            return matchingInfo.get(mission);
        }
        throw CustomException.errorMessage(NO_MATCHING_HISTORY);
    }

    /**
     * clear Pair
     */
    public void clear() {
        matchingInfo.clear();
    }

    public boolean isEmpty(Mission mission) {
        return !matchingInfo.containsKey(mission);
    }

    public List<Pairs> getSameLevelPairs(Mission mission) {
        List<Pairs> pairs = new ArrayList<>();
        for (Mission others : matchingInfo.keySet()) {
            if (others.equals(mission)) {
                continue;
            }

            if (others.getLevel() == mission.getLevel()) {
                pairs.add(matchingInfo.get(mission));
            }
        }
        return pairs;
    }


}
