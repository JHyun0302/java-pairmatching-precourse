package pairmatching.model;

import pairmatching.exception.CustomException;

import java.util.Arrays;
import java.util.List;

import static pairmatching.exception.ErrorMessage.SELECT_FUNCTION_MUST_BE_1_OR_2_OR_3_OR_Q;

public class Function {
    public static final List<String> RESPONSE = Arrays.asList("1", "2", "3", "Q");
    private final String function;

    public Function(String function) {
        validate();
        this.function = function;
    }


    public static Function createFunction(String function) {
        return new Function(function);
    }

    private String validate() {
        for (String response : RESPONSE) {
            if (RESPONSE.contains(response)) {
                return response;
            }
        }
        throw CustomException.errorMessage(SELECT_FUNCTION_MUST_BE_1_OR_2_OR_3_OR_Q);
    }

    public String getFunction() {
        return function;
    }
}
