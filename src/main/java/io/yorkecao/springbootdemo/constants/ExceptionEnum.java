package io.yorkecao.springbootdemo.constants;

import lombok.Getter;

/**
 * @author Yorke
 */
@Getter
public enum ExceptionEnum {
    /**
     * 成功
     */
    SUCCESS("200", "SUCCESS"),
    /**
     * 一般异常
     */
    ERROR("600", "ERROR");

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
