package pairmatching.exception;

public class ErrorInputException extends IllegalArgumentException {
    public enum ErrorMessage {
        CANNOT_BE_NULL_OR_EMPTY("입력값이 빈 값이거나 null 값 일 수 없습니다."),

        SELECT_FUNCTION_MUST_BE_1_OR_2_OR_3_OR_Q("기능 선택은 1, 2, 3, Q 값이여야 합니다."),

        ERROR_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
        PROCESS_ARE_BACKEND_OR_FRONTEND("페어 매칭 과정은 백엔드 또는 프론트엔드 입니다. 다시 입력해 주세요."),
        MISSION_ARE_BETWEEN_ONE_AND_FIVE("페어 매칭 미션은 1 ~ 5 사이 입니다. 다시 입력해 주세요."),

        LEVEL_AND_MISSION_ARE_NOT_MATCHED("해당 레벨에 미션이 없습니다."),
        PROCESS_IS_NOT_EXISTED("유효하지 않은 과정입니다.");

        ErrorMessage(final String message) {
            this.message = message;
        }

        private final String errorMessage = "[ERROR] ";

        private final String message;

        public String getErrorMessage() {
            return errorMessage;
        }

        public String getMessage() {
            return message;
        }

    }

    public ErrorInputException(ErrorMessage message) {
        super(message.getErrorMessage() + message.getMessage());
    }
}
