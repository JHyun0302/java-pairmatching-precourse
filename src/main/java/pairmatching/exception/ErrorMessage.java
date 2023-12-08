package pairmatching.exception;

public enum ErrorMessage {
    CANNOT_BE_NULL_OR_EMPTY("입력값이 빈 값이거나 null 값 일 수 없습니다."),
    SELECT_FUNCTION_MUST_BE_1_OR_2_OR_3_OR_Q("기능 선택은 1, 2, 3, Q 값이여야 합니다."),
    ERROR_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    INVALID_REMATCH_REQUEST("네 / 아니요를 입력해야합니다. 다시 입력해 주세요."),
    PROCESS_IS_NOT_EXISTED("유효하지 않은 과정입니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
