package io.yorkecao.springbootdemo.utils;

import io.yorkecao.springbootdemo.constants.ExceptionEnum;
import io.yorkecao.springbootdemo.domain.DemoException;
import io.yorkecao.springbootdemo.domain.Result;

/**
 * @author Yorke
 */
public class ResultUtil {

    public static Result success() {
        return new Result(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getMessage());
    }

    public static Result success(Object object) {
        return new Result(ExceptionEnum.SUCCESS.getCode(), ExceptionEnum.SUCCESS.getMessage(), object);
    }

    public static Result error() {
        return new Result(ExceptionEnum.ERROR.getCode(), ExceptionEnum.ERROR.getMessage());
    }

    public static Result error(String errorMessage) {
        return new Result(ExceptionEnum.ERROR.getCode(), errorMessage);
    }

    public static Result error(ExceptionEnum exceptionEnum) {
        return new Result(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }

    public static Result error(DemoException demoException) {
        return new Result(demoException.getCode(), demoException.getMessage());
    }
}
