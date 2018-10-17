package io.yorkecao.springbootdemo.constants;

import lombok.Getter;

/**
 * @author Yorke
 */
@Getter
public enum DemoResponse {
    /**
     * 成功
     */
    SUCCESS("200", "SUCCESS"),
    /**
     * 失败
     */
    ERROR("600", "ERROR");

    private String code;
    private String message;

    DemoResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
