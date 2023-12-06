package pairmatching.constant;

public enum Function {
    PLZ_INPUT_FUNCTION("기능을 선택하세요."),
    PAIR_MATCHING("1. 페어 매칭"),
    SEARCHING_PAIR("2. 페어 조회"),
    INIT_PAIR("3. 페어 초기화"),
    QUIT("Q. 종료");

    public final String message;

    Function(String message) {
        this.message = message;
    }

}
