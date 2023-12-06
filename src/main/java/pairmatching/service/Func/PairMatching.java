package pairmatching.service.Func;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.model.Pair;
import pairmatching.repository.PairRepository;

public class PairMatching implements Func {

    private static final int MAX_RETRIES = 3;

    // 페어 매칭 기록
    private Map<String, Set<String>> pairs;

    public PairMatching() {
        // 기존 페어 매칭 기록 로드
        pairs = PairRepository.pairs();
    }

    @Override
    public boolean process(MissionInfo mission, Crews initCrew) {
        List<Crew> crews = initCrew.getCrews(mission.getProcess(), initCrew);
        crews.get().getName()
        int retryCount = 0;
        while (retryCount < MAX_RETRIES) {
            List<String> shuffledCrew = new ArrayList<>();
            Randoms.shuffle(shuffledCrew);
            List<Pair> pairs = createPairs(shuffledCrew);
            if (isValidPairs(pairs)) {
                updatePairHistory(pairs);
                return true;
            }
            retryCount++;
        }

        System.out.println("페어 매칭에 실패했습니다.");
        return false;
    }

    private List<Pair> createPairs(List<String> shuffledCrew) {
        List<Pair> pairs = new ArrayList<>();
        int size = shuffledCrew.size();
        for (int i = 0; i < size; i += 2) {
            if (i == size - 1) { // 홀수인 경우 마지막 페어는 3인으로 구성
                pairs.add(
                        new Pair(Arrays.asList(shuffledCrew.get(i - 1), shuffledCrew.get(i), shuffledCrew.get(i + 1))));
                break;
            }
            pairs.add(new Pair(Arrays.asList(shuffledCrew.get(i), shuffledCrew.get(i + 1))));
        }
        return pairs;
    }

    private boolean isValidPairs(List<Pair> pairs) {
        for (Pair pair : pairs) {
            List<String> members = pair.getMembers();
            for (String member : members) {
                if (pairHistory.getOrDefault(member, new HashSet<>()).containsAll(members)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updatePairHistory(List<Pair> pairs) {
        for (Pair pair : pairs) {
            List<String> members = pair.getMembers();
            for (String member : members) {
                Set<String> history = pairHistory.getOrDefault(member, new HashSet<>());
                history.addAll(members);
                pairHistory.put(member, history);
            }
        }
    }
}
}
