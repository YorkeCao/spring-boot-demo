package io.yorkecao.springbootdemo.domain;

import io.yorkecao.springbootdemo.constants.ExceptionEnum;
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

    public DemoException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    @Override
    public String toString() {
        return "code：" + code + "，message：" + message;
    }
}
