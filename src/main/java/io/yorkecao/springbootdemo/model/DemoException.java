package io.yorkecao.springbootdemo.model;

import io.yorkecao.springbootdemo.constants.ExceptionType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yorke
 */
@Data
public class DemoException extends RuntimeException {

    ExceptionType exceptionType;

    public DemoException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getCode() {
        return exceptionType.getCode();
    }

    @Override
    public String getMessage() {
        return exceptionType.getMessage();
    }

    @Override
    public String toString() {
        return "code：" + getCode() + "，message：" + getMessage();
    }
}
