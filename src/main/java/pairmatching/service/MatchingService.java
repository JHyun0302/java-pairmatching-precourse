package pairmatching.service;

import static pairmatching.exception.ErrorMessage.FAIL_MATCHING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.exception.CustomException;
import pairmatching.model.Pair;
import pairmatching.model.Pairs;
import pairmatching.model.constant.Course;
import pairmatching.model.constant.Mission;
import pairmatching.repository.MatchingRepository;

public class MatchingService {
    private static final int MAX_MATCHING_COUNT = 3;
    private final CrewService crewService;
    private final MatchingRepository matchingRepository;

    public MatchingService(CrewService crewService, MatchingRepository matchingRepository) {
        this.crewService = crewService;
        this.matchingRepository = matchingRepository;
    }

    public Pairs getPairs(Mission mission) {
        return matchingRepository.getPairs(mission);
    }

    public boolean hasNoPairs(Mission mission) {
        return matchingRepository.isEmpty(mission);
    }

    public Pairs generateMatching(Course course, Mission mission) {
        for (int i = 0; i < MAX_MATCHING_COUNT; i++) {
            Pairs generateParis = generateParis(course);
            boolean canMatch = hasNotDuplicatedMatching(mission, generateParis);
            if (canMatch) {
                matchingRepository.save(mission, generateParis);
                return generateParis;
            }
        }
        throw CustomException.errorMessage(FAIL_MATCHING);
    }

    private Pairs generateParis(Course course) {
        Pairs pairs = Pairs.createPairs();
        List<String> crews = Randoms.shuffle(crewService.getCrews(course));

        if (crews.size() % 2 == 1 && crews.size() >= 3) {
            pairs.add(generateTripleCrew(crews));
        }
        for (int i = 0; i < crews.size(); i += 2) {
            pairs.add(generateCoupleCrew(crews.get(i), crews.get(i + 1)));
        }
        return pairs;
    }

    private Pair generateCoupleCrew(String crew1, String crew2) {
        Pair pair = Pair.createPair();
        pair.add(crew1);
        pair.add(crew2);
        return pair;
    }

    private Pair generateTripleCrew(List<String> crews) {
        Pair pair = Pair.createPair();
        for (int i = 0; i < 3; i++) {
            int last = crews.size() - 1;
            pair.add(crews.get(last));
            crews.remove(last);
        }
        return pair;
    }

    private boolean hasNotDuplicatedMatching(Mission mission, Pairs pairs) {
        List<Pairs> sameLevelPairs = matchingRepository.getSameLevelPairs(mission);
        for (Pairs others : sameLevelPairs) {
            if (pairs.duplicated(others)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        matchingRepository.clear();
    }
}
