package io.yorkecao.springbootdemo.domain;

import io.yorkecao.springbootdemo.constants.ExceptionType;
import io.yorkecao.springbootdemo.model.DemoException;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yorke
 */
@Getter
@Setter
public class Result {
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应对象
     */
    private Object data;

    public Result() {
        code = ExceptionType.SUCCESS.getCode();
        message = ExceptionType.SUCCESS.getMessage();
    }

    public Result(String message) {
        code = ExceptionType.SUCCESS.getCode();
        this.message = message;
    }

    public Result(Object data) {
        code = ExceptionType.SUCCESS.getCode();
        message = ExceptionType.SUCCESS.getMessage();
        this.data = data;
    }

    public Result(ExceptionType exceptionType) {
        code = exceptionType.getCode();
        message = exceptionType.getMessage();
    }

    public Result(ExceptionType exceptionType, Object data) {
        code = exceptionType.getCode();
        message = exceptionType.getMessage();
        this.data = data;
    }

    public Result(DemoException demoException) {
        code = demoException.getCode();
        message = demoException.getMessage();
    }

    public Result(DemoException demoException, Object data) {
        this.code = demoException.getCode();
        this.message = demoException.getMessage();
        this.data = data;
    }

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
