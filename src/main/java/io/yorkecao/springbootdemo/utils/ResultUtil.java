package io.yorkecao.springbootdemo.utils;

import io.yorkecao.springbootdemo.constants.ExceptionType;
import io.yorkecao.springbootdemo.domain.model.DemoException;
import io.yorkecao.springbootdemo.domain.Result;

/**
 * @author Yorke
 */
public class ResultUtil {

    public static Result success() {
        return new Result(ExceptionType.SUCCESS.getCode(), ExceptionType.SUCCESS.getMessage());
    }

    public static Result success(Object object) {
        return new Result(ExceptionType.SUCCESS.getCode(), ExceptionType.SUCCESS.getMessage(), object);
    }

    public static Result error() {
        return new Result(ExceptionType.ERROR.getCode(), ExceptionType.ERROR.getMessage());
    }

    public static Result error(String errorMessage) {
        return new Result(ExceptionType.ERROR.getCode(), errorMessage);
    }

    public static Result error(ExceptionType exceptionType) {
        return new Result(exceptionType.getCode(), exceptionType.getMessage());
    }

    public static Result error(DemoException demoException) {
        return new Result(demoException.getCode(), demoException.getMessage());
    }
}
