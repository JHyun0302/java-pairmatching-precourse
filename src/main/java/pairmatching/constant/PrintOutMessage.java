package pairmatching.constant;

public enum PrintOutMessage {
    PAIR_MATCHING_RESULT("페어 매칭 결과입니다."),
    PAIR_MATCHING_INIT("초기화 되었습니다."),
    PAIR_DECO(":"),
    SPACE(" "),
    EXIT("종료"),
    NONE("없음");

    public final String message;

    PrintOutMessage(String message) {
        this.message = message;
    }
}
