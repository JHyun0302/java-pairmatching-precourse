package pairmatching.controller.Func;

import static pairmatching.exception.ErrorMessage.INVALID_FUNCTION;

import pairmatching.exception.CustomException;

public class ErrorInput implements Func {
    @Override
    public boolean process() {
        throw CustomException.errorMessage(INVALID_FUNCTION);
    }
}
