package io.yorkecao.springbootdemo.constants;

import lombok.Getter;

/**
 * @author Yorke
 */
@Getter
public enum ExceptionType {
    /**
     * 成功
     */
    SUCCESS("200", "SUCCESS"),
    /**
     * 一般异常
     */
    ERROR("4000000", "ERROR"),
    // 查询异常 01
    SELECT_ERROR_CAN_NOT_FIND_USER("4000100", "找不到用户！");

    private String code;
    private String message;

    ExceptionType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
