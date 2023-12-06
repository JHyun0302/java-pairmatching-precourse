package pairmatching.constant;

public enum SelectProcess {
    DECO("#############################################"),
    INFO_PROCESS("과정: 백엔드 | 프론트엔드"),
    INFO_MISSION("미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: "),
    PLZ_INPUT_PROCESS("과정, 레벨, 미션을 선택하세요."),
    INPUT_EXAMPLE("ex) 백엔드, 레벨1, 자동차경주");
    public final String message;

    SelectProcess(String message) {
        this.message = message;
    }
}
