package pairmatching.model;

import static pairmatching.exception.ErrorMessage.SELECT_FUNCTION_NOT_EXIST;

import java.util.Arrays;
import java.util.List;
import pairmatching.exception.CustomException;

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
        throw CustomException.errorMessage(SELECT_FUNCTION_NOT_EXIST);
    }

    public String getFunction() {
        return function;
    }
}
