package io.yorkecao.springbootdemo.domain.model;

import io.yorkecao.springbootdemo.constants.ExceptionType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yorke
 */
@Getter
@Setter
public class DemoException extends RuntimeException {

    private String code;
    private String message;

    public DemoException(ExceptionType exceptionType) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
    }

    @Override
    public String toString() {
        return "code：" + code + "，message：" + message;
    }
}
