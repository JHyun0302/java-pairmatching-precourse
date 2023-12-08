package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {
    private List<Pair> pairs;

    private Pairs() {
        this.pairs = new ArrayList<>();
    }

    public void add(Pair pair) {
        pairs.add(pair);
    }
    
    public static Pairs createPairs() {
        return new Pairs();
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }

    /**
     * 서로 다른 미션의 매칭 정보를 비교하여, 중복되는 페어가 있는 지 확인
     */
    public boolean duplicated(Pairs others) {
        for (Pair pair : pairs) {
            if (duplicated(pair, others)) {
                return false;
            }
        }
        return true;
    }

    private boolean duplicated(Pair pair, Pairs others) {
        return others.getPairs().stream().noneMatch(pair::duplicated);
    }
}
